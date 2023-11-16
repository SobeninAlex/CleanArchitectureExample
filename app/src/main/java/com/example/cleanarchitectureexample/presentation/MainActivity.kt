package com.example.cleanarchitectureexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.example.cleanarchitectureexample.databinding.ActivityMainBinding

import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(applicationContext)
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val text = binding.editText.text.toString()
            val params = SaveUserNameParam(text)
            val result = saveUserNameUseCase.execute(param = params)
            binding.dataTextView.text = "Save result = $result"
        }

        binding.getButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            binding.dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }

}