plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "org.mrmat.plugins.gradle.container"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/MrMatAP/mrmat-gradle-plugins")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("gpr.user") as String?
                password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.token") as String?
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
