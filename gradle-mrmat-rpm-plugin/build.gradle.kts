plugins {
    `kotlin-dsl`
}

group = "org.mrmat.plugins.gradle.rpm"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

gradlePlugin {
    plugins {
        create("rpmBasePlugin") {
            id = "org.mrmat.plugins.gradle.rpm.base"
            implementationClass = "org.mrmat.plugins.gradle.rpm.RPMBasePlugin"
        }
        create("rpmPlugin") {
            id = "org.mrmat.plugins.gradle.rpm"
            implementationClass = "org.mrmat.plugins.gradle.rpm.RPMPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
