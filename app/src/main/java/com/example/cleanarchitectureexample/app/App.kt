package com.example.cleanarchitectureexample.app

import android.app.Application
import com.example.cleanarchitectureexample.di.AppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()



    }

}