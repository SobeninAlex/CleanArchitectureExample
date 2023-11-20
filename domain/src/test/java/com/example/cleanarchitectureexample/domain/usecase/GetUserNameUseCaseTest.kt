package com.example.cleanarchitectureexample.domain.usecase

import com.example.cleanarchitectureexample.domain.models.UserName
import com.example.cleanarchitectureexample.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")

        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actualResult = useCase.execute()
        val expectedResult = UserName(firstName = "test first name", lastName = "test last name")

        Assertions.assertEquals(expectedResult, actualResult)
    }

}