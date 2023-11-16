package com.example.cleanarchitectureexample.domain.usecase

import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        return userRepository.saveName(saveParam = param)
    }

}