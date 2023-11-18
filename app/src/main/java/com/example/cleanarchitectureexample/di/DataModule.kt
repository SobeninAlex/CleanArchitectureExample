package com.example.cleanarchitectureexample.di

import android.content.Context
import com.example.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.example.cleanarchitectureexample.data.storage.UserStorage
import com.example.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitectureexample.domain.repository.UserRepository
import dagger.Module

@Module
class DataModule {

    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}