object Dependencies {
    //std lib
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    // android ui
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.core}"

    // LifeCycle
    const val lifecycleLiveDataKtxCore =
        "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Koin
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinCoreExt = "io.insert-koin:koin-core-ext:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinAndroidExt = "io.insert-koin:koin-android-ext:${Versions.koin}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConvertGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // OkHtpp
    const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okHttp}"
    const val okHttp = "com.squareup.okhttp3:okhttp"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    const val okHttpMockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"

    // Gson
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //test libs
    const val junit = "junit:junit:${Versions.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

}