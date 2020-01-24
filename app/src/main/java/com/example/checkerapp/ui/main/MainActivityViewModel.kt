package com.example.checkerapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.ServerResponse
import com.example.checkerapp.repository.ApiRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeApiRepository = ApiRepository()
    val employee = MutableLiveData<Employee>()
    val error = MutableLiveData<String>()

    fun getEmployeeByPassId(passId: Long) {
        employeeApiRepository.getEmployeeByPassId(passId).enqueue(object : Callback<Employee> {
            override fun onResponse(call : Call<Employee>, response: Response<Employee>) {
                if (response.isSuccessful) employee.value = response.body()!!
                else {
                    val serverResponse = Gson().fromJson(response.errorBody()!!.string()
                        , ServerResponse::class.java)
                    error.value = serverResponse.message
                }
            }

            override fun onFailure(call: Call<Employee>, t: Throwable) {
                error.value = t.message
            }

        })
    }
}