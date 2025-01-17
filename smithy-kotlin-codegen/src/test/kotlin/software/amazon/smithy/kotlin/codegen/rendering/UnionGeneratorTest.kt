/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0.
 */
package software.amazon.smithy.kotlin.codegen.rendering

import io.kotest.matchers.string.shouldContainOnlyOnce
import software.amazon.smithy.codegen.core.SymbolProvider
import software.amazon.smithy.kotlin.codegen.KotlinCodegenPlugin
import software.amazon.smithy.kotlin.codegen.core.KotlinWriter
import software.amazon.smithy.kotlin.codegen.model.expectShape
import software.amazon.smithy.kotlin.codegen.test.TestModelDefault
import software.amazon.smithy.kotlin.codegen.test.createSymbolProvider
import software.amazon.smithy.kotlin.codegen.test.prependNamespaceAndService
import software.amazon.smithy.kotlin.codegen.test.shouldContainOnlyOnceWithDiff
import software.amazon.smithy.kotlin.codegen.test.shouldContainWithDiff
import software.amazon.smithy.kotlin.codegen.test.toSmithyModel
import software.amazon.smithy.kotlin.codegen.trimEveryLine
import software.amazon.smithy.model.shapes.UnionShape
import kotlin.test.Test
import kotlin.test.assertFailsWith

class UnionGeneratorTest {
    @Test
    fun `it renders unions`() {
        val contents = generateUnion(
            """
                @documentation("Documentation for MyUnion")
                union MyUnion {
                    @documentation("Documentation for foo")
                    foo: String,
                    bar: PrimitiveInteger,
                    baz: Integer,
                    blz: Blob,
                    myStruct: MyStruct
                }

                structure MyStruct {
                    qux: String
                }
            """
        )
        contents.shouldContainOnlyOnceWithDiff("package test")

        val expectedClassDecl = """
            /**
             * Documentation for MyUnion
             */
            sealed class MyUnion {
                data class Bar(val value: kotlin.Int) : test.model.MyUnion()
                data class Baz(val value: kotlin.Int) : test.model.MyUnion()
                data class Blz(val value: kotlin.ByteArray) : test.model.MyUnion() {
            
                    override fun hashCode(): kotlin.Int {
                        return value.contentHashCode()
                    }
            
                    override fun equals(other: kotlin.Any?): kotlin.Boolean {
                        if (this === other) return true
                        if (javaClass != other?.javaClass) return false
            
                        other as Blz
            
                        if (!value.contentEquals(other.value)) return false
            
                        return true
                    }
                }
                /**
                 * Documentation for foo
                 */
                data class Foo(val value: kotlin.String) : test.model.MyUnion()
                data class MyStruct(val value: test.model.MyStruct) : test.model.MyUnion()
                object SdkUnknown : test.model.MyUnion()
            }
        """.trimIndent()

        contents.shouldContainWithDiff(expectedClassDecl)
    }

    @Test
    fun `it fails to generate unions with colliding member names`() {
        val model = """
            structure MyStruct {
                qux: String,
            }
           
            union MyUnion {                
                sdkUnknown: String
            }
        """.prependNamespaceAndService().toSmithyModel()
        val union = model.expectShape<UnionShape>("com.test#MyUnion")

        val provider: SymbolProvider = KotlinCodegenPlugin.createSymbolProvider(model)
        val writer = KotlinWriter(TestModelDefault.NAMESPACE)
        val generator = UnionGenerator(model, provider, writer, union)

        assertFailsWith<IllegalStateException> {
            generator.render()
        }
    }

    @Test
    fun `it annotates deprecated unions`() {
        val contents = generateUnion(
            """
                @deprecated
                union MyUnion {
                    foo: String,
                    bar: Integer,
                }
            """
        )

        contents.shouldContainOnlyOnce(
            """
                @Deprecated("No longer recommended for use. See AWS API documentation for more details.")
                sealed class MyUnion {
            """.trimIndent()
        )
    }

    @Test
    fun `it annotates deprecated union members`() {
        val contents = generateUnion(
            """
                union MyUnion {
                    foo: String,

                    @deprecated
                    bar: Integer,
                }
            """
        )

        contents.trimEveryLine().shouldContainOnlyOnce(
            """
                @Deprecated("No longer recommended for use. See AWS API documentation for more details.")
                data class Bar(val value: kotlin.Int) : test.model.MyUnion()
            """.trimIndent()
        )
    }

    private fun generateUnion(model: String): String {
        val fullModel = model.prependNamespaceAndService(namespace = "test").toSmithyModel()

        val provider: SymbolProvider = KotlinCodegenPlugin.createSymbolProvider(fullModel, rootNamespace = "test")
        val writer = KotlinWriter("test")
        val union = fullModel.expectShape<UnionShape>("test#MyUnion")
        val generator = UnionGenerator(fullModel, provider, writer, union)
        generator.render()

        return writer.toString()
    }
}
