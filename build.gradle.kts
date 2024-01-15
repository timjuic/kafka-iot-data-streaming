plugins {
    id("application")
}

application {
    // Specify the main class for your application
    mainClass.set("me.timjuice.Main")
}

group = "me.timjuice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.apache.kafka:kafka-clients:3.6.1")
    implementation("ch.qos.logback:logback-classic:1.4.12")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0-rc1")
}
