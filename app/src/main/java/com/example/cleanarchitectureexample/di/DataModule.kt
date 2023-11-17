package com.example.cleanarchitectureexample.di

import com.example.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.example.cleanarchitectureexample.data.storage.UserStorage
import com.example.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitectureexample.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}