plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "org.mrmat.plugins.gradle.helm"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

    //
    // For parsing YAML

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.1")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

gradlePlugin {
    plugins {
        create("helmBasePlugin") {
            id = "org.mrmat.plugins.gradle.helm.base"
            implementationClass = "org.mrmat.plugins.gradle.helm.HelmBasePlugin"
        }
        create("helmPlugin") {
            id = "org.mrmat.plugins.gradle.helm"
            implementationClass = "org.mrmat.plugins.gradle.helm.HelmPlugin"
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
