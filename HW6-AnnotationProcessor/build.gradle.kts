plugins {
    id("java")
    id("maven-publish")
}

group = "ru.otus"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.auto.service:auto-service:1.1.1")

}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "ru.otus"
            artifactId = "AnnotationProcessor"
            version = "1.0"
            from(components["java"])
        }
        repositories {
            mavenLocal()
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}