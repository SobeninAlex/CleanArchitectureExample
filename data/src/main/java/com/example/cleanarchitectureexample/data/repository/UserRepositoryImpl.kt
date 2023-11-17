package com.example.cleanarchitectureexample.data.repository

import com.example.cleanarchitectureexample.data.storage.models.User
import com.example.cleanarchitectureexample.data.storage.UserStorage
import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.models.UserName
import com.example.cleanarchitectureexample.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

}