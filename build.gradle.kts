/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0.
 */
buildscript {
    repositories {
        mavenCentral()
        google()
    }

    val kotlinVersion: String by project
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    kotlin("jvm") apply false
    id("org.jetbrains.dokka")
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    id("se.bjurr.gitchangelog.git-changelog-gradle-plugin") version "1.71.4"
}

apply(plugin = "se.bjurr.gitchangelog.git-changelog-gradle-plugin")

tasks.register<se.bjurr.gitchangelog.plugin.gradle.GitChangelogTask>("changelog") {
    file = File("CHANGELOG.md")
    fromRepo = "/home/ANT.AMAZON.COM/kggilmer/dev/repos/smithy-kotlin"
    // fromCommit = "dc4e5949342157d0a598f076152d5eab2052e1af"
    toRef = "main"
    // println("KGWH $fromRepo")
    templateContent = """ 
        # Changelog

        {{#tags}}
        {{#ifReleaseTag .}}
        ## [{{name}}](https://gitlab.com/html-validate/html-validate/compare/{{name}}) ({{tagDate .}})

          {{#ifContainsType commits type='feat'}}
        ### Features

            {{#commits}}
              {{#ifCommitType . type='feat'}}
         - {{#eachCommitScope .}} **{{.}}** {{/eachCommitScope}} {{{commitDescription .}}} ([{{hash}}](https://gitlab.com/html-validate/html-validate/commit/{{hashFull}}))
              {{/ifCommitType}}
            {{/commits}}
          {{/ifContainsType}}

          {{#ifContainsType commits type='fix'}}
        ### Bug Fixes

            {{#commits}}
              {{#ifCommitType . type='fix'}}
         - {{#eachCommitScope .}} **{{.}}** {{/eachCommitScope}} {{{commitDescription .}}} ([{{hash}}](https://gitlab.com/html-validate/html-validate/commit/{{hashFull}}))
              {{/ifCommitType}}
            {{/commits}}
          {{/ifContainsType}}

        {{/ifReleaseTag}}
        {{/tags}}
    """.trimIndent()
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

if (project.properties["kotlinWarningsAsErrors"]?.toString()?.toBoolean() == true) {
    subprojects {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.allWarningsAsErrors = true
        }
    }
}

apply(from = rootProject.file("gradle/codecoverage.gradle"))

if (
    project.hasProperty("sonatypeUsername") &&
    project.hasProperty("sonatypePassword") &&
    project.hasProperty("publishGroupName")
) {
    apply(plugin = "io.github.gradle-nexus.publish-plugin")

    val publishGroupName = project.property("publishGroupName") as String
    group = publishGroupName

    nexusPublishing {
        packageGroup.set(publishGroupName)
        repositories {
            create("awsNexus") {
                nexusUrl.set(uri("https://aws.oss.sonatype.org/service/local/"))
                snapshotRepositoryUrl.set(uri("https://aws.oss.sonatype.org/content/repositories/snapshots/"))
                username.set(project.property("sonatypeUsername") as String)
                password.set(project.property("sonatypePassword") as String)
            }
        }
    }
}

val ktlint by configurations.creating
val ktlintVersion: String by project

dependencies {
    ktlint("com.pinterest:ktlint:$ktlintVersion")
    ktlint(project(":ktlint-rules"))
}

val lintPaths = listOf(
    "smithy-kotlin-codegen/src/**/*.kt",
    "runtime/**/*.kt",
    "benchmarks/**/jvm/*.kt",
)

tasks.register<JavaExec>("ktlint") {
    description = "Check Kotlin code style."
    group = "Verification"
    classpath = configurations.getByName("ktlint")
    main = "com.pinterest.ktlint.Main"
    args = lintPaths
}

tasks.register<JavaExec>("ktlintFormat") {
    description = "Auto fix Kotlin code style violations"
    group = "formatting"
    classpath = configurations.getByName("ktlint")
    main = "com.pinterest.ktlint.Main"
    args = listOf("-F") + lintPaths
}
