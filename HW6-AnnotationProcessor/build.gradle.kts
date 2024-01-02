plugins {
    id("java")
    id("maven-publish")
}

group = "ru.otus"

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    compileOnly("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")

}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "ru.otus"
            artifactId = "AnnotationProcessor"
            version = "1.4"
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