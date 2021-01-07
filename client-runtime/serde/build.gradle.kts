/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0.
 */

description = "Serialization and deserialization for Smithy services generated by smithy-kotlin"
extra["displayName"] = "Smithy :: Kotlin :: Serde"
extra["moduleName"] = "software.aws.clientrt.serde"

subprojects {
    kotlin {
        sourceSets {
            commonTest {
                dependencies {
                    implementation(project(":client-runtime:testing"))
                }
            }
        }
    }
}
