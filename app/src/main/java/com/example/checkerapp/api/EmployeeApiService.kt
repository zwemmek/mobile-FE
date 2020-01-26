package com.example.checkerapp.api

import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.LoggedInUser
import com.example.checkerapp.model.ServerResponse
import com.example.checkerapp.model.StatusHistory
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

    @GET("/checker/services/rest/status/{employeeId}/history/{limit}")
    fun getStatusHistory(@Path("employeeId") employeeId: Long,
                         @Path("limit") limit: Int) : Call<List<StatusHistory>>

    @POST("checker/services/rest/authentication")
    fun loginEmployee(@Body loggedInUser: LoggedInUser): Call <ServerResponse>

}