package com.example.cleanarchitectureexample.di

import android.content.Context
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitectureexample.presentation.presenter.MainPresenterImpl
import com.example.cleanarchitectureexample.presentation.view.MainView
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainPresenterImpl(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase,
        view: MainView
    ): MainPresenterImpl {
         return MainPresenterImpl(
             getUserNameUseCase = getUserNameUseCase,
             saveUserNameUseCase = saveUserNameUseCase,
             view = view
         )
    }

}