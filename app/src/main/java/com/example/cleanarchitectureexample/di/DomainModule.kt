package com.example.cleanarchitectureexample.di

import com.example.cleanarchitectureexample.domain.repository.UserRepository
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import dagger.Module

@Module
class DomainModule {

    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }

}