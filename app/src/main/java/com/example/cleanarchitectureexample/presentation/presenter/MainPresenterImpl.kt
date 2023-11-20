package com.example.cleanarchitectureexample.presentation.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import com.example.cleanarchitectureexample.presentation.view.MainView

class MainPresenterImpl(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val view: MainView
) : MainPresenter {

    override fun save(text: String) {
        val params = SaveUserNameParam(text)
        val resultData = saveUserNameUseCase.execute(param = params)
        view.showResult("Save result = $resultData")
    }

    override fun load() {
        val userName = getUserNameUseCase.execute()
        view.showResult("${userName.firstName} ${userName.lastName}")
    }

}