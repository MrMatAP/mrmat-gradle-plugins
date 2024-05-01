plugins {
    `kotlin-dsl`
}

group = "org.mrmat.plugins.gradle.container"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

gradlePlugin {
    plugins {
        create("containerBasePlugin") {
            id = "org.mrmat.plugins.gradle.container.base"
            implementationClass = "org.mrmat.plugins.gradle.container.ContainerBasePlugin"
        }
        create("containerPlugin") {
            id = "org.mrmat.plugins.gradle.container"
            implementationClass = "org.mrmat.plugins.gradle.container.ContainerPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
