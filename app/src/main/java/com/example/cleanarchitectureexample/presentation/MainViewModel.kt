package com.example.cleanarchitectureexample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _state = MutableLiveData<MainState>()
    val state: LiveData<MainState> = _state

    init {
        _state.value = MainState(saveResult = false, firstName = "", lastName = "")
    }

    fun send(event: MainEvent) {
        when (event) {
            is SaveEvent -> save(text = event.text)
            is LoadEvent -> load()
        }
    }

    private fun save(text: String) {
        val params = SaveUserNameParam(text)
        val resultData = saveUserNameUseCase.execute(param = params)
        _state.value = MainState(
            saveResult = resultData,
            firstName = _state.value?.firstName ?: "",
            lastName = _state.value?.firstName ?: "",
        )
    }

    private fun load() {
        val userName = getUserNameUseCase.execute()
        _state.value = MainState(
            saveResult = _state.value!!.saveResult,
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }

}
