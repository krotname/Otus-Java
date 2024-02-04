import com.google.protobuf.gradle.id

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
    implementation("io.grpc:grpc-protobuf:1.60.1")
    implementation("io.grpc:grpc-stub:1.60.1")
    implementation("io.grpc:grpc-netty:1.60.1")
    implementation("com.google.protobuf:protobuf-java:3.25.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.springframework.boot:spring-boot-starter:3.2.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val protoSrcDir = "$projectDir/build/generated/main/proto"

idea {
    module {
        sourceDirs = sourceDirs.plus(file(protoSrcDir))
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.60.1"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

afterEvaluate {
    tasks {
        getByName("generateProto").dependsOn(processResources)
    }
}
