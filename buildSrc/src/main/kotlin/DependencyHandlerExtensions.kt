import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.coreKtx() {
    implementation(AndroidX.CoreKtx.DEPENDENCY)
}

fun DependencyHandler.lifecycle() {
    implementation(AndroidX.Lifecycle.DEPENDENCY)
}

fun DependencyHandler.activity() {
    implementation(AndroidX.ActivityCompose.DEPENDENCY)
}

fun DependencyHandler.compose() {
    implementation(AndroidX.Compose.UI)
    implementation(AndroidX.Compose.MATERIAL)
    implementation(AndroidX.Compose.PREVIEW)
    implementation(AndroidX.Compose.NAVIGATION)
    debugImplementation(AndroidX.Compose.UI_TOOLING)
    debugImplementation(AndroidX.Compose.TEST_MANIFEST)
}

fun DependencyHandler.unitTesting() {
    testImplementation(Testing.JUnit.DEPENDENCY)
    testCompileOnly(Testing.JUnit.API_DEPENDENCY)
    testRuntimeOnly(Testing.JUnit.ENGINE)
    testImplementation(Testing.JUnit.PARAMS)
    testImplementation(Testing.AssertJ.DEPENDENCY)
    testImplementation(AndroidX.CoreKtx.Testing.DEPENDENCY)
    testImplementation(Testing.Mockk.DEPENDENCY)
}

fun DependencyHandler.module(name: String) {
    implementation(project(mapOf("path" to name)))
}

private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

private fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

private fun DependencyHandler.ksp(dependency: String) {
    add("ksp", dependency)
}

private fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

private fun DependencyHandler.testRuntimeOnly(dependency: String) {
    add("testRuntimeOnly", dependency)
}

private fun DependencyHandler.testCompileOnly(dependency: String) {
    add("testCompileOnly", dependency)
}
