package com.uhc.lovepet

import android.app.Application
import com.facebook.stetho.Stetho
import com.uhc.lovepet.di.dataModule
import com.uhc.lovepet.di.domainModule
import com.uhc.lovepet.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LovePetApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

        startKoin {
            androidLogger()
            androidContext(this@LovePetApp)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}
