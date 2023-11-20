package com.example.cleanarchitectureexample.domain.usecase

import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.models.UserName
import com.example.cleanarchitectureexample.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun teardown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if name was already saved`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val testParams = SaveUserNameParam(name = "test first name")

        val actual = useCase.execute(testParams)
        Assertions.assertTrue(actual)
        Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())
    }

    @Test
    fun `should return true if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(true)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val actual = useCase.execute(testParams)
        Assertions.assertTrue(actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

    @Test
    fun `should return false if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val testParams = SaveUserNameParam(name = "new first name")
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(false)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val actual = useCase.execute(testParams)
        Assertions.assertFalse(actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

}