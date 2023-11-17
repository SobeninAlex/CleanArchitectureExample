package com.example.cleanarchitectureexample.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.example.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun save(text: String) {
        val params = SaveUserNameParam(text)
        val resultData = saveUserNameUseCase.execute(param = params)
        _result.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _result.value = "${userName.firstName} ${userName.lastName}"
    }

}


class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(SharedPrefUserStorage(context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }

}