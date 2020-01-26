package com.example.checkerapp.ui.change

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.ServerResponse
import com.example.checkerapp.model.StatusHistory
import com.example.checkerapp.repository.EmployeeApiRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangeActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val employeeApiRepository = EmployeeApiRepository()
    val employee = MutableLiveData<StatusHistory>()
    val serverResponse = MutableLiveData<ServerResponse>()
    val error = MutableLiveData<String>()

    fun getCurrentStatusByWorkerId(employeeId: Long) {
        employeeApiRepository.getCurrentStatusByWorkerId(employeeId).enqueue(object : Callback<StatusHistory> {
            override fun onResponse(call : Call<StatusHistory>, response: Response<StatusHistory>) {
                if (response.isSuccessful) employee.value = response.body()!!
                else {
                    val serverResponse = Gson().fromJson(response.errorBody()!!.string()
                        , ServerResponse::class.java)
                    error.value = serverResponse.message
                }
            }

            override fun onFailure(call: Call<StatusHistory>, t: Throwable) {
                error.value = t.message
            }

        })
        }

    fun changeStatus(employeeId: Long) {
        employeeApiRepository.changeStatus(employeeId).enqueue(object : Callback<ServerResponse> {
            override fun onResponse(call : Call<ServerResponse>, response: Response<ServerResponse>) {
                if (response.isSuccessful) serverResponse.value = response.body()!!
                else {
                    val serverResponse = Gson().fromJson(response.errorBody()!!.string()
                        , ServerResponse::class.java)
                    error.value = serverResponse.message
                }
            }

            override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                error.value = t.message
            }

        })
    }
}



