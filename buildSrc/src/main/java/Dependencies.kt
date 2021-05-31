object Dependencies {
    //std lib
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    // android ui
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val core = "androidx.core:core-ktx:${Versions.core}"

    //test libs
    const val junit = "junit:junit:${Versions.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"


}