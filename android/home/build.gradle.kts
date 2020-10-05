plugins {
    id("kotlin-android")
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.Kotlin.stdlib)
    implementation(Deps.CoreKtx.coreKtx)
    implementation(Deps.AppCompat.appCompat)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // Tests
    testImplementation(Deps.Junit.junit)
    androidTestImplementation(Deps.ExtJunit.extJunit)
    androidTestImplementation(Deps.Espresso.espressoCore)

    implementation(Deps.Material.material)

    implementation(Deps.JetpackNavigation.navigationFragmentKtx)
    implementation(Deps.JetpackNavigation.navigationUiKtx)

    implementation(Deps.Koin.koinAndroid)
    implementation(Deps.Koin.koinViewModel)

    implementation(project(":navigation"))
    implementation(project(":core"))
}