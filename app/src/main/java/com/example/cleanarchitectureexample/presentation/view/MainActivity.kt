package com.example.cleanarchitectureexample.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitectureexample.app.App
import com.example.cleanarchitectureexample.databinding.ActivityMainBinding
import com.example.cleanarchitectureexample.presentation.presenter.MainPresenterImpl
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        binding.saveButton.setOnClickListener {
            val text = binding.editText.text.toString()
            presenter.save(text)
        }

        binding.getButton.setOnClickListener {
            presenter.load()
        }
    }

    override fun showResult(text: String) {
        binding.dataTextView.text = text
    }

}