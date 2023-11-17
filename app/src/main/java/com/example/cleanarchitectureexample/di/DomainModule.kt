package com.example.cleanarchitectureexample.di

import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetUserNameUseCase(userRepository = get())
    }

    factory {
        SaveUserNameUseCase(userRepository = get())
    }

}