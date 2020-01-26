package com.example.checkerapp.api

import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.ServerResponse
import com.example.checkerapp.model.StatusHistory
import retrofit2.Call
import retrofit2.http.*

interface EmployeeApiService {

    @GET("/checker/services/rest/employee/{passId}")
    fun getEmployeeByPassId(@Path("passId") passId: Long): Call<Employee>

    @POST("/checker/services/rest/employee")
    fun registerEmployee(@Body employee: Employee): Call<ServerResponse>

    @GET("/checker/services/rest/status/{employeeId}/history/{limit}")
    fun getStatusHistory(@Path("employeeId") employeeId: Long,
                         @Path("limit") limit: Int) : Call<List<StatusHistory>>

    @GET ("/checker/services/rest/status/{employeeId}")
    fun getCurrentStatusByWorkerId(@Path("employeeId") employeeId: Long):Call<StatusHistory>

    @PUT("/checker/services/rest/status/{employeeId}/change")
    fun changeStatus(@Path("employeeId") employeeId: Long): Call<ServerResponse>
    }
