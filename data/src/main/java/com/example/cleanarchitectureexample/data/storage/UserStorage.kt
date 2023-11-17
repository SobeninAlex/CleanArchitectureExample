package com.example.cleanarchitectureexample.data.storage

import com.example.cleanarchitectureexample.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}