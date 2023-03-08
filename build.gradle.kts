import org.jetbrains.kotlin.config.KotlinCompilerVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.com.google.common.base.Optional

version = "0.0.1"

val javaVersion = JavaVersion.VERSION_19
val kotlinVersion: String = Optional.of(KotlinCompilerVersion.VERSION).or("1.8.10")

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}


plugins {
    application
    kotlin("jvm") version "1.8.10"
}


repositories {
    mavenCentral()
}


dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = javaVersion.ordinal.toString()
}

tasks.withType<JavaCompile>().configureEach {
    options.isIncremental = true
}

application {
    mainClass.set("Main")
}
