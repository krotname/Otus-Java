plugins {
    id("java")
}

group = "ru.otus"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")

    implementation("ch.qos.logback:logback-classic")
    implementation("com.google.code.gson:gson")
    implementation("org.hibernate.orm:hibernate-core")
    implementation("org.flywaydb:flyway-core")
    implementation("org.apache.commons:commons-lang3:3.12.0")

    implementation("org.eclipse.jetty:jetty-servlet:11.0.17")
    implementation("org.eclipse.jetty:jetty-server:11.0.17")
    implementation("org.eclipse.jetty:jetty-webapp:11.0.17")
    implementation("org.eclipse.jetty:jetty-security:11.0.17")
    implementation("org.eclipse.jetty:jetty-http:11.0.17")
    implementation("org.eclipse.jetty:jetty-io:11.0.17")
    implementation("org.eclipse.jetty:jetty-util:11.0.17")
    implementation("org.freemarker:freemarker")


    implementation("org.postgresql:postgresql")

    testImplementation("com.h2database:h2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.mockito:mockito-junit-jupiter")

    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

tasks.test {
    useJUnitPlatform()
}