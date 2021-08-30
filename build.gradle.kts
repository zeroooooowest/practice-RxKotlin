plugins {
    kotlin("jvm") version "1.5.30"
}

group = "me.zw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.5.30")
}
