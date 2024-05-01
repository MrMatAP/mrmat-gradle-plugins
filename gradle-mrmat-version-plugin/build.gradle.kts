plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "org.mrmat.plugins.gradle.version"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

    //
    // To generate code holding the version

    implementation("com.squareup:kotlinpoet:1.16.0")
    implementation("com.squareup:javapoet:1.13.0")
}

gradlePlugin {
    plugins {
        create("versionBasePlugin") {
            id = "org.mrmat.plugins.gradle.version.base"
            implementationClass = "org.mrmat.plugins.gradle.version.VersionBasePlugin"
        }
        create("versionPlugin") {
            id = "org.mrmat.plugins.gradle.version"
            implementationClass = "org.mrmat.plugins.gradle.version.VersionPlugin"
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
