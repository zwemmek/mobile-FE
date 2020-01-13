package com.example.checkerapp.repository

import com.example.checkerapp.api.EmployeeApi
import com.example.checkerapp.api.EmployeeApiService

class EmployeeApiRepository {
    private val employeeApi: EmployeeApiService = EmployeeApi.createApi()

    fun getEmployeeByPassId(passId: Long) = employeeApi.getEmployeeByPassId(passId)

}