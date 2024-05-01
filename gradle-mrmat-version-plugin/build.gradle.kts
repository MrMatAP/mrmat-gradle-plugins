plugins {
    `kotlin-dsl`
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
            id = "org.mrmat.plugins.version"
            implementationClass = "org.mrmat.plugins.gradle.version.VersionPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
