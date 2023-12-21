plugins {
    java
    id("com.google.protobuf") version "0.9.4"
    id("idea")
}

group = "ru.otus"
version = "0.0.2-SNAPSHOT"


repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("io.grpc:grpc-netty:1.60.1")
    implementation("io.grpc:grpc-protobuf:1.60.1")
    implementation("io.grpc:grpc-stub:1.60.1")
    implementation("com.google.protobuf:protobuf-java:4.0.0-rc-2")
    implementation("org.springframework.boot:spring-boot-starter:3.2.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
