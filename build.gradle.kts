plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
}

buildscript {
    val kotlinVersion = extra["kotlin.version"] as String

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(uri("https://plugins.gradle.org/m2/")) // For kotlinter-gradle
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")

        classpath("dev.icerock.moko.widgets:gradle-plugin:0.1.0")
    }
}
object Versions {
    const val androidMinSdk = 21
    const val androidCompileSdk = 33
    const val androidTargetSdk = androidCompileSdk

    const val kotlinCoroutines = "1.6.4"
    const val koin = "3.2.1"

    const val kotlinxSerialization = "1.3.3"

    const val compose = "1.5.1"
    const val composeUi = "1.3.1"
    const val composeCompiler = "1.3.2"
    const val navCompose = "2.5.2"
    const val composeMaterial3 = "1.0.0-beta03"
    const val materialIconsExtended = "1.3.1"

    const val junit = "4.12"
    const val androidXTestJUnit = "1.1.3"
    const val testCore = "1.3.0"
    const val mockito = "3.11.2"
    const val robolectric = "4.6.1"

    const val sqlDelight = "1.5.3"
    const val kotlinterGradle = "3.4.5"

    const val activityCompose = "1.6.0-rc02"
    const val lifecycleKtx = "2.6.0-alpha02"
    const val lifecycleRuntimeKtx = lifecycleKtx
    const val lifecycleViewmodelKtx = lifecycleKtx
//    const val osmdroidAndroid = "6.1.10"

    const val kermit = "1.0.0"
    const val gradleVersionsPlugin = "0.39.0"

    const val arrow = "1.0.1"

    const val settings = "1.0.0-RC"


    const val moko = "0.14.0"

    const val napier = "2.6.1"

    const val zxing = "3.3.0"
    const val zxing_embedded = "4.3.0"

    const val camera = "1.0.2"
    const val cameraView = "1.0.0-alpha31"

    const val collection = "1.3.0-dev01"
    const val datastore = "1.1.0-dev01"

    const val lingver = "1.3.0"
    const val mapbox = "10.10.0-beta.1"
    const val constraintLayout = "2.1.4"

    const val coil = "2.2.2"
    const val viewModel = "1.0.0"

    const val collectionsImmutable = "0.3.5"

    const val materialDialog = "0.9.0"
    const val kotlinxDateTime = "0.4.0"
    const val wheelPickerComposeVersion = "1.1.10"

}


object Compose{
    const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val ui = "androidx.compose.ui:ui:${Versions.composeUi}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.composeUi}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUi}"
    const val foundationLayout =
        "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val materialIcons =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navCompose}"
    const val materialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.materialIconsExtended}"

    const val coilCompose = "io.coil-kt:coil-compose:2.0.0"
}