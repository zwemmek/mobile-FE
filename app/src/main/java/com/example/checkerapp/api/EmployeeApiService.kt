package com.example.checkerapp.api

import com.example.checkerapp.model.Employee
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeApiService {

    @GET("/checker/services/rest/employee/{passId}")
    fun getEmployeeByPassId(@Path("passId") passId: Long): Call<Employee>

}