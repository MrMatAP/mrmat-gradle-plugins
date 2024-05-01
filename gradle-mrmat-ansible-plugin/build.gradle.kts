plugins {
    `kotlin-dsl`
}

group = "org.mrmat.plugins.gradle.ansible"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

    //
    // For parsing YAML

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
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

tasks.test {
    useJUnitPlatform()
}
