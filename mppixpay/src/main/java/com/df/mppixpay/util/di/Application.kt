package com.df.mppixpay.util.di

import android.app.Application

class Application: Application() {
    override fun onCreate() {

        super.onCreate()

        /*startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@Application)
            modules(
                listOf(
                    viewModelsModule,
                    repositoryesModule,
                    apisModule
                )
            )*/
            /*koin.loadModules(
                listOf(
                    viewModelsModule,
                    repositoryesModule,
                    apisModule
                )
            )*/
            //koin.createRootScope()
        //}
    }

}