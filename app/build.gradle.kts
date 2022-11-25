/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
  id("kotlin")
  id("org.openjfx.javafxplugin") version "0.0.13"
  id("vanity.kotlin-application-conventions")
}


javafx {
  version = "17.0.2"
  modules = listOf("javafx.controls")
}

dependencies {
  api(project(":utilities"))

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.6.4")

  val koinVersion = "3.2.2"
  implementation("io.insert-koin:koin-core:$koinVersion")

}

application {
  // Define the main class for the application.
  mainClass.set("vanity.app.AppKt")

}



