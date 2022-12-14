
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

repositories {
    gradlePluginPortal()
    mavenCentral()
}

plugins {
    `java-library`
    `maven-publish`

    id("org.openjfx.javafxplugin") version "0.0.13"
    id("org.jetbrains.kotlin.jvm") version "1.7.22"
}


javafx {
    version = "17.0.2"
    modules = listOf("javafx.controls")
}

dependencies {


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.6.4")

    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")
    implementation("ch.qos.logback:logback-classic:1.4.5")

    implementation("io.insert-koin:koin-core:3.3.0")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
    testImplementation("io.kotest:kotest-assertions-core:5.5.4")

}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

java {
    withJavadocJar()
    withSourcesJar()
}

    apply<MavenPublishPlugin>()

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/SilenLoc/vanity")
                credentials {
                    username = System.getenv("GITHUB_USERNAME")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
            }
        }
    }

