dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.CoreKtx.coreKtx)
    implementation(Deps.AppCompat.appCompat)

    // Tests
    testImplementation(Deps.Junit.junit)
    androidTestImplementation(Deps.ExtJunit.extJunit)
    androidTestImplementation(Deps.Espresso.espressoCore)

    implementation(Deps.Material.material)

    implementation(Deps.JetpackNavigation.navigationFragmentKtx)
    implementation(Deps.JetpackNavigation.navigationUiKtx)

    implementation(Deps.Koin.koinAndroid)
    implementation(Deps.Koin.koinViewModel)

    implementation(Deps.Flexbox.flexbox)

    implementation(Deps.Google.authKtx)
    implementation(Deps.Google.servicesAuth)

    implementation(Deps.Lifecycle.lifecycleExtension)
    implementation(Deps.Lifecycle.lifecycleViewModelKtx)

    implementation(project(":navigation"))
    implementation(project(":core"))
}
