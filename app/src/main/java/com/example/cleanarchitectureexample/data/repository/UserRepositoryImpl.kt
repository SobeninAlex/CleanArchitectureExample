package com.example.cleanarchitectureexample.data.repository

import android.content.Context
import com.example.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.example.cleanarchitectureexample.domain.models.UserName
import com.example.cleanarchitectureexample.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "key_first_name"
private const val KEY_LAST_NAME = "key_last_name"

class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit()
            .putString(KEY_FIRST_NAME, saveParam.name)
            .apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "default firstName").toString()
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "default lastNme").toString()
        return UserName(firstName = firstName, lastName = lastName)
    }

}