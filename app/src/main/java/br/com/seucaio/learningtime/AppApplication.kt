package br.com.seucaio.learningtime

import android.app.Application
import br.com.seucaio.learningtime.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@AppApplication)
            AppModule.init()
        }
    }
}