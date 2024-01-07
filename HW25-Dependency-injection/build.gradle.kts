plugins {
    id("java")
}

group = "ru.otus"

repositories {
    mavenCentral()
}

tasks.register<Wrapper>("wrapper") {
    gradleVersion = "8.4"
}

tasks.register("prepareKotlinBuildScriptModel") {}


dependencies {
    implementation("org.reflections:reflections:0.10.2")

    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.mockito:mockito-junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}