android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
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

    implementation(Deps.Material.material)

    implementation(Deps.ConstraintLayout.constraintLayout)

    implementation(Deps.Lifecycle.lifecycleExtension)

    implementation(Deps.JetpackNavigation.navigationFragmentKtx)
    implementation(Deps.JetpackNavigation.navigationUiKtx)

    debugImplementation(Deps.DebugDrawer.debugDrawer)
    implementation(Deps.DebugDrawer.debugDrawerBase)
    implementation(Deps.DebugDrawer.debugDrawerActions)
    implementation(Deps.DebugDrawer.debugDrawerCommons)
    implementation(Deps.DebugDrawer.debugDrawerLogs)
    releaseImplementation(Deps.DebugDrawer.debugDrawerNoOp)
    implementation(Deps.DebugDrawer.debugDrawerOkhttp)
    implementation(Deps.DebugDrawer.debugDrawerOkhttp3)
    implementation(Deps.DebugDrawer.debugDrawerTimber)
    
    debugImplementation(Deps.Chuck.chuckLibrary)
    releaseImplementation(Deps.Chuck.chuckLibraryNoOp)

    implementation(Deps.Lynx.lynx)

    implementation(Deps.Koin.koinAndroid)

    implementation(Deps.OkHttp.okHttp)

    // Tests
    testImplementation(Deps.Junit.junit)
    androidTestImplementation(Deps.ExtJunit.extJunit)
    androidTestImplementation(Deps.Espresso.espressoCore)

    implementation(project(":navigation"))
    implementation(project(":core"))
}