package com.example.checkerapp.repository

import com.example.checkerapp.api.EmployeeApi
import com.example.checkerapp.api.EmployeeApiService
import com.example.checkerapp.model.Employee


class EmployeeApiRepository {
    private val employeeApi: EmployeeApiService = EmployeeApi.createApi()

    fun getEmployeeByPassId(passId: Long) = employeeApi.getEmployeeByPassId(passId)
    fun registerEmployee(employee: Employee) = employeeApi.registerEmployee(employee)
}