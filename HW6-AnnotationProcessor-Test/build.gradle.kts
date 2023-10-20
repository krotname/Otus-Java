plugins {
    id("java")
}

group = "ru.otus"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("ru.otus:HW6-AnnotationProcessor-Maven:2.1-SNAPSHOT")
    annotationProcessor("ru.otus:HW6-AnnotationProcessor-Maven:2.1-SNAPSHOT")

}

allprojects {
    tasks.withType<JavaCompile>().configureEach {
//        options.compilerArgs.add("-Werror")
        options.isDeprecation = true
    }
}

tasks.test {
    useJUnitPlatform()
}