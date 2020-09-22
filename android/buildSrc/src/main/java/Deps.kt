object Deps {
    object BuildGradle {
        private const val version = "4.0.1"
        const val buildGradleTool = "com.android.tools.build:gradle:$version"
    }

    object Kotlin {
        private const val version = "1.4.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
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
        const val navigationFragment = "androidx.navigation:navigation-fragment:$version"
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUi = "androidx.navigation:navigation-ui:$version"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Lifecycle {
        private const val version = "2.2.0"
        const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:$version"
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