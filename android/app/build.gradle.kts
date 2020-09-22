android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.CoreKtx.coreKtx)
    implementation(Deps.AppCompat.appCompat)
    implementation(Deps.LegacySupport.legacySupport)

    // Material
    implementation(Deps.Material.material)

    // ConstraintLayout
    implementation(Deps.ConstraintLayout.constraintLayout)

    // Lifecycle
    implementation(Deps.Lifecycle.lifecycleExtension)

    // Jetpack Navigation
    implementation(Deps.JetpackNavigation.navigationFragment)
    implementation(Deps.JetpackNavigation.navigationUi)
    implementation(Deps.JetpackNavigation.navigationFragmentKtx)
    implementation(Deps.JetpackNavigation.navigationUiKtx)

    // Tests
    testImplementation(Deps.Junit.junit)
    androidTestImplementation(Deps.ExtJunit.extJunit)
    androidTestImplementation(Deps.Espresso.espressoCore)
}