plugins {
    id("java")
}

group = "ru.otus"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.reflections:reflections")

    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.mockito:mockito-junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}