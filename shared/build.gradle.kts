plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
    id ("kotlin-parcelize")


}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)


                api("io.insert-koin:koin-core:3.4.3")
                api("io.insert-koin:koin-compose:1.0.4")

                val ktor = "2.2.2"

                implementation("io.ktor:ktor-client-core:${ktor}")
                implementation("io.ktor:ktor-client-json:${ktor}")
                implementation("io.ktor:ktor-client-logging:${ktor}")
                implementation("io.ktor:ktor-client-auth:${ktor}")
                implementation("io.ktor:ktor-client-content-negotiation:${ktor}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor}")
                implementation("io.ktor:ktor-client-resources:${ktor}")


                val arrow = "1.0.1"

                implementation("io.arrow-kt:arrow-core:${arrow}")
                implementation("io.arrow-kt:arrow-fx-coroutines:${arrow}")
                implementation("io.arrow-kt:arrow-fx-stm:${arrow}")


                // region Kotlinx

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")




                api("dev.icerock.moko:mvvm-core:0.16.1") // only ViewModel, EventsDispatcher, Dispatchers.UI
                api("dev.icerock.moko:mvvm-compose:0.16.1") // api mvvm-core, getViewModel for Compose Multiplatfrom



                implementation("media.kamel:kamel-image:0.9.1")

//                //navigation
//                val voyagerVersion = "1.0.0-rc07"
//                implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
//                implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
//                implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

//                implementation ("androidx.navigation:navigation-compose:2.4.0-alpha01")

                implementation("io.github.xxfast:decompose-router:0.4.0")
                implementation("com.arkivanov.decompose:decompose:2.1.2")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:2.1.0-compose-experimental-alpha-07")
                implementation("com.arkivanov.essenty:parcelable:1.2.0")
            }
        }
        val androidMain by getting {
            val koinVersion = "3.3.2"
            dependencies {
                api("androidx.activity:activity-compose:1.7.2")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")

                implementation("io.ktor:ktor-client-android:2.2.2")
                implementation("io.ktor:ktor-client-okhttp:2.2.2")


                api("io.insert-koin:koin-android:$koinVersion")

                implementation("com.google.accompanist:accompanist-navigation-animation:0.28.0")
                implementation("com.google.accompanist:accompanist-navigation-material:0.28.0")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies{
                implementation("io.ktor:ktor-client-darwin:2.2.2")
                implementation("io.ktor:ktor-client-darwin:2.2.2")

                implementation("com.squareup.sqldelight:native-driver:1.5.3")

                implementation("io.github.xxfast:decompose-router:0.4.0")
                implementation("com.arkivanov.decompose:decompose:2.1.2")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:2.1.0-compose-experimental-alpha-07")
                implementation("com.arkivanov.essenty:parcelable:1.2.0")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.2")
    implementation("androidx.navigation:navigation-compose:2.7.7")
}
