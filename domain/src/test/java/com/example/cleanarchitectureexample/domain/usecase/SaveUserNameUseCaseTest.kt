package com.example.cleanarchitectureexample.domain.usecase

import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.models.UserName
import com.example.cleanarchitectureexample.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should not save data if name was already saved`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val testParams = SaveUserNameParam(name = "test first name")

        val actual = useCase.execute(testParams)
        Assertions.assertTrue(actual)
    }

}