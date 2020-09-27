dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.CoreKtx.coreKtx)
    implementation(Deps.AppCompat.appCompat)

    implementation(Deps.Timber.timber)

    implementation(Deps.Koin.koinAndroid)

    implementation(Deps.DebugDrawer.debugDrawerTimber)

    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.retrofitMoshi)
    implementation(Deps.Retrofit.retrofitScalars)

    implementation(Deps.OkHttp.okHttp)

    implementation(Deps.Material.material)

    implementation(Deps.Coil.coil)

    implementation(Deps.JetpackNavigation.navigationFragmentKtx)

    // Tests
    testImplementation(Deps.Junit.junit)
    androidTestImplementation(Deps.ExtJunit.extJunit)
    androidTestImplementation(Deps.Espresso.espressoCore)
}