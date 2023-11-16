package com.example.cleanarchitectureexample.domain.usecase

import com.example.cleanarchitectureexample.domain.models.UserName
import com.example.cleanarchitectureexample.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }

}