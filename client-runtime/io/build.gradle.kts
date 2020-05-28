description = "IO primitives for Smithy services generated by smithy-kotlin"
extra["displayName"] = "Smithy :: Kotlin :: IO"
extra["moduleName"] = "software.aws.clientrt.io"

val ktorVersion: String by project

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":client-runtime:utils"))
                // TODO - for ByteChannel abstractions. switch to kotlinx-io if/when available
                implementation("io.ktor:ktor-io:$ktorVersion")
            }
        }
        jvmMain {
            dependencies {
                implementation("io.ktor:ktor-io-jvm:$ktorVersion")
            }
        }
    }
}
