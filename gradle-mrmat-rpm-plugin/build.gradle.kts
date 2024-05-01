plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "org.mrmat.plugins.gradle.rpm"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/MrMatAP/mrmat-gradle-plugins")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
