package com.example.checkerapp.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.checkerapp.model.ServerResponse
import com.example.checkerapp.model.StatusHistory
import com.example.checkerapp.repository.EmployeeApiRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val apiRepository = EmployeeApiRepository()
    val history = MutableLiveData<List<StatusHistory>>()
    val error = MutableLiveData<String>()

    fun getStatusHistory(employeeId: Long, limit: Int) {
        apiRepository.getStatusHistory(employeeId, limit).enqueue(object : Callback<List<StatusHistory>> {
            override fun onResponse(call : Call<List<StatusHistory>>, response: Response<List<StatusHistory>>) {
                if (response.isSuccessful) history.value = response.body()!!
                else {
                    val serverResponse = Gson().fromJson(response.errorBody()!!.string()
                        , ServerResponse::class.java)
                    error.value = serverResponse.message
                }
            }

            override fun onFailure(call: Call<List<StatusHistory>>, t: Throwable) {
                error.value = t.message
            }

        })
    }
}