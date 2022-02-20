package com.df.mppixpay.util.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Application)
            modules(
                listOf(
                    viewModelsModule,
                    repositoryesModule,
                    apisModule
                )
            )
            /*koin.loadModules(
                listOf(
                    viewModelsModule,
                    repositoryesModule,
                    apisModule
                )
            )*/
            //koin.createRootScope()
        }
    }

}