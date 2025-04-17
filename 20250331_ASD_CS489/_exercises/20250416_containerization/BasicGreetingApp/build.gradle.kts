plugins {
    id("java")
}

group = "edu.miu.cs489.containerization"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar{
    archiveBaseName = "myapp"
    archiveVersion = "1.0.1"

    manifest {
        attributes["Main-Class"] = "edu.miu.cs489.containerization.Main"
    }
}