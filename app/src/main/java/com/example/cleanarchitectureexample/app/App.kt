package com.example.cleanarchitectureexample.app

import android.app.Application
import com.example.cleanarchitectureexample.di.AppComponent
import com.example.cleanarchitectureexample.di.AppModule
import com.example.cleanarchitectureexample.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }

}