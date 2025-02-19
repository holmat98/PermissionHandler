plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.ANDROID_KOTLIN)
    id(Plugins.JACOCO)
    id(Plugins.MAVEN_PUBLISH)
    id(AndroidGitVersion.PLUGIN)
    id(AndroidX.Compose.COMPILER_PLUGIN)
}

androidGitVersion {
    format = AndroidGitVersion.FORMAT_LIBRARY
}

android.configure(
    namespace = "com.mateuszholik.permissionhandler",
    isUsingCompose = true
)

task(name = "sourceJar", type = Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components.getByName("release"))
                groupId = "com.github.holmat98"
                artifactId = "permission-handler"
                version = androidGitVersion.name()

                pom.licenses {
                    license {
                        name = "Apache License 2.0"
                        url = "https://github.com/holmat98/permission-handler/blob/main/LICENSE"
                        distribution = "repo"
                    }
                }
            }
        }
    }
}

dependencies {
    coreKtx()
    implementation(AndroidX.Compose.UI)
    implementation(AndroidX.ActivityCompose.DEPENDENCY)
    unitTesting()
}

tasks.withType(Test::class) {
    useJUnitPlatform()
}
