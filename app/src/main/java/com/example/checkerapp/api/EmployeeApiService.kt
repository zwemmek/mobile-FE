package com.example.checkerapp.api

import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.ServerResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmployeeApiService {

    @GET("/checker/services/rest/employee/{passId}")
    fun getEmployeeByPassId(@Path("passId") passId: Long): Call<Employee>

    @POST("/checker/services/rest/employee")
    fun registerEmployee(@Body employee: Employee): Call<ServerResponse>

}