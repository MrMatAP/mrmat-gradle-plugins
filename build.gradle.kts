allprojects {

    version = System.getenv("MRMAT_VERSION") ?: "0.0.0-SNAPSHOT"

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
