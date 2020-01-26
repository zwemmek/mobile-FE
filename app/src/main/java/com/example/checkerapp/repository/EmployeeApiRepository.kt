package com.example.checkerapp.repository

import com.example.checkerapp.api.EmployeeApi
import com.example.checkerapp.api.EmployeeApiService
import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.LoggedInUser


class EmployeeApiRepository {
    private val employeeApi: EmployeeApiService = EmployeeApi.createApi()

    fun getEmployeeByPassId(passId: Long) = employeeApi.getEmployeeByPassId(passId)
    fun registerEmployee(employee: Employee) = employeeApi.registerEmployee(employee)
    fun getStatusHistory(employeeId: Long, limit: Int) = employeeApi.getStatusHistory(employeeId, limit)
    fun loginEmployee(loggedInUser: LoggedInUser) = employeeApi.loginEmployee(loggedInUser)
}