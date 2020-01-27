package com.example.checkerapp.ui.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

import com.example.checkerapp.R
import com.example.checkerapp.model.LoggedInUser
import com.example.checkerapp.model.ServerResponse
import com.example.checkerapp.repository.EmployeeApiRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeApiRepository = EmployeeApiRepository()
    val serverResponse = MutableLiveData<String>()
    val error = MutableLiveData<String>()

    fun login(loggedInUser: LoggedInUser) {
        employeeApiRepository.loginEmployee(loggedInUser).enqueue(object : Callback<Void> {
            override fun onResponse(call : Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) serverResponse.value = "200"
                else {
                    error.value = "Geen geldige login"
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                error.value = t.message
            }

        })
    }
}
