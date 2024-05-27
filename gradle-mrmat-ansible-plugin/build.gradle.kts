plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "org.mrmat.plugins.gradle.ansible"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")

    //
    // For parsing YAML

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

gradlePlugin {
    plugins {
        create("ansibleBasePlugin") {
            id = "org.mrmat.plugins.gradle.ansible.base"
            implementationClass = "org.mrmat.plugins.gradle.ansible.AnsibleBasePlugin"
        }
        create("containerPlugin") {
            id = "org.mrmat.plugins.gradle.ansible"
            implementationClass = "org.mrmat.plugins.gradle.ansible.AnsiblePlugin"
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
