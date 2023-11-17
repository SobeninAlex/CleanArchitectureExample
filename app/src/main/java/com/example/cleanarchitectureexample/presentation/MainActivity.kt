package com.example.cleanarchitectureexample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitectureexample.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.save(text)
        }

        binding.getButton.setOnClickListener {
            viewModel.load()
        }

        viewModel.result.observe(this) {
            binding.dataTextView.text = it
        }
    }

}