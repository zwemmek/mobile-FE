package com.example.checkerapp.api

import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.StatusHistory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeApiService {

    @GET("/checker/services/rest/employee/{passId}")
    fun getEmployeeByPassId(@Path("passId") passId: Long): Call<Employee>

    @GET("/checker/services/rest/status/{employeeId}/history/{limit}")
    fun getStatusHistory(@Path("employeeId") employeeId: Long,
                         @Path("limit") limit: Int) : Call<List<StatusHistory>>

}