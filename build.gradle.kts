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
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
}

//tasks.test {
//    useJUnitPlatform()
//}