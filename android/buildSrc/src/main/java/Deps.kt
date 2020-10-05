object Deps {
    object BuildGradle {
        private const val version = "4.0.1"
        const val buildGradleTool = "com.android.tools.build:gradle:$version"
    }

    object Kotlin {
        private const val version = "1.4.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object CoreKtx {
        private const val version = "1.3.1"
        const val coreKtx = "androidx.core:core-ktx:$version"
    }

    object AppCompat {
        private const val version = "1.2.0"
        const val appCompat = "androidx.appcompat:appcompat:$version"
    }

    object LegacySupport {
        private const val version = "1.0.0"
        const val legacySupport = "androidx.legacy:legacy-support-v4:$version"
    }

    object Material {
        private const val version = "1.2.1"
        const val material = "com.google.android.material:material:$version"
    }

    object ConstraintLayout {
        private const val version = "2.0.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
    }

    object JetpackNavigation {
        private const val version = "2.3.0"
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        const val navSafeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
    }

    object Lifecycle {
        private const val version = "2.2.0"
        const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:$version"
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Koin {
        private const val version = "2.1.6"
        // Koin for Android
        const val koinAndroid = "org.koin:koin-android:$version"
        // or Koin for Lifecycle scoping
        const val koinScope = "org.koin:koin-androidx-scope:$version"
        // or Koin for Android Architecture ViewModel
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitScalars = "com.squareup.retrofit2:converter-scalars:$version"
        const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object OkHttp {
        private const val version = "4.8.0"
        const val okHttp = "com.squareup.okhttp3:okhttp:$version"
    }

    object Coroutine {
        private const val version = "1.3.9"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object RoomDb {
        private const val version = "2.2.5"
        const val roomRuntime = "androidx.room:room-runtime:$version"
        const val roomCompiler = "androidx.room:room-compiler:$version"
        // optional - Kotlin Extensions and Coroutines support for Room
        const val roomKtx = "androidx.room:room-ktx:$version"
    }

    object DebugDrawer {
        private const val version = "0.8.0"
        const val debugDrawerActions = "io.palaima.debugdrawer:debugdrawer-actions:$version"
        const val debugDrawerBase = "io.palaima.debugdrawer:debugdrawer-base:$version"
        const val debugDrawerNoOp = "io.palaima.debugdrawer:debugdrawer-no-op:$version"
        const val debugDrawer = "io.palaima.debugdrawer:debugdrawer:$version"
        const val debugDrawerCommons = "io.palaima.debugdrawer:debugdrawer-commons:$version"
        const val debugDrawerOkhttp = "io.palaima.debugdrawer:debugdrawer-okhttp:$version"
        const val debugDrawerOkhttp3 = "io.palaima.debugdrawer:debugdrawer-okhttp3:$version"
        const val debugDrawerTimber = "io.palaima.debugdrawer:debugdrawer-timber:$version"
        const val debugDrawerLogs = "io.palaima.debugdrawer:debugdrawer-logs:$version"
    }

    // used by debug drawer
    object Lynx {
        private const val version = "1.1.0"
        const val lynx = "com.github.pedrovgs:lynx:$version"
    }

    // used by debug drawer
    object Chuck {
        private const val version = "1.1.0"
        // use debugImplementation
        const val chuckLibrary = "com.readystatesoftware.chuck:library:$version"
        // use releaseImplementation
        const val chuckLibraryNoOp = "com.readystatesoftware.chuck:library-no-op:$version"
    }

    object Lottie {
        private const val version = "3.4.2"
        const val lottie = "com.airbnb.android:lottie:$version"
    }

    object Coil {
        private const val version = "1.0.0-rc3"
        const val coil = "io.coil-kt:coil:$version"
    }

    object Google {
        private const val services_version = "4.3.3"
        private const val analytics_version = "17.5.0"
        private const val auth_version = "19.4.0"
        private const val services_auth = "18.1.0"
        private const val crashlytics_version = "17.2.1"

        const val googleServices = "com.google.gms:google-services:$services_version"
        const val analyticsKtx = "com.google.firebase:firebase-analytics-ktx:$analytics_version"
        const val authKtx = "com.google.firebase:firebase-auth-ktx:$auth_version"
        const val servicesAuth = "com.google.android.gms:play-services-auth:$services_auth"
        const val crashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx:$crashlytics_version"
    }

    object Facebook {
        private const val version = "[5,6)"
        const val facebook = "com.facebook.android:facebook-login:$version"
    }

    object Flexbox {
        private const val version = "2.0.1"
        const val flexbox = "com.google.android:flexbox:$version"
    }

    object Timber {
        private const val version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object Junit {
        private const val version = "4.12"
        const val junit = "junit:junit:$version"
    }

    object ExtJunit {
        private const val version = "1.1.2"
        const val extJunit = "androidx.test.ext:junit:$version"
    }

    object Espresso {
        private const val version = "3.3.0"
        const val espressoCore = "androidx.test.espresso:espresso-core:$version"
    }
}