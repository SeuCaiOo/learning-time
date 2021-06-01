package br.com.seucaio.learningtime

import android.app.Application
import br.com.seucaio.learningtime.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startTimber()
        startKoin()
    }

    private fun startTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            AppModule.init()
        }
    }
}