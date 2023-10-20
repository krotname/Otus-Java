plugins {
    id("java")
}

group = "ru.otus"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("ru.otus:AnnotationProcessor:1.0")

}

tasks.test {
    useJUnitPlatform()
}