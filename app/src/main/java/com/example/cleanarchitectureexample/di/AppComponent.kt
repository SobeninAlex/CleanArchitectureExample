package com.example.cleanarchitectureexample.di

import com.example.cleanarchitectureexample.presentation.view.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}