package com.example.checkerapp.repository

import com.example.checkerapp.api.EmployeeApiService
import com.example.checkerapp.api.LoginDataSource
import com.example.checkerapp.model.LoggedInUser
import retrofit2.Call


class LoginRepository(val dataSource: EmployeeApiService) {

    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(passId: String, password: String): Call<LoggedInUser> {

        val result = dataSource.loginEmployee(passId, password)

        if (result is Result.Success<*>) {
            setLoggedInUser(result.data as LoggedInUser)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}
