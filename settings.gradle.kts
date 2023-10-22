rootProject.name = "otusJava"

pluginManagement {
    val jgitver: String by settings
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val johnrengelmanShadow: String by settings
    val jib: String by settings

    plugins {
        id("fr.brouillard.oss.gradle.jgitver") version jgitver
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
        id("com.google.cloud.tools.jib") version jib
    }
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

include("hw01-gradle")
include("hw06-annotations")
include("hw08-gc")
include("hw10-log")
include("hw12-ATM")
include("HW15-patterns")
include("hw16-JSON")
include("HW19-ORM")
include("HW21-JPA")
include("hw22-cache")
include("HW25-Dependency-injection")
