plugins {
    `kotlin-dsl`
}

group = "org.mrmat.plugins.gradle.helm"

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

tasks.test {
    useJUnitPlatform()
}
