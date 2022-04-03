package com.example.moviesapp.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    fun validateUser(user: String, password: String){
        if (user == "admin" && password == "123456"){
            _error.postValue(true)
        } else{
            _error.postValue(false)
        }
    }

}