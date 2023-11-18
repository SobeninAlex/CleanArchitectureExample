package com.example.cleanarchitectureexample.di

import android.content.Context
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitectureexample.presentation.MainViewModelFactory
import dagger.Module

@Module
class AppModule(val context: Context) {

    fun provideContext(): Context {
        return context
    }

    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
         return MainViewModelFactory(
             getUserNameUseCase = getUserNameUseCase,
             saveUserNameUseCase = saveUserNameUseCase
         )
    }

}