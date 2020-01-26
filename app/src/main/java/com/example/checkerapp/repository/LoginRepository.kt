package com.example.checkerapp.repository

import com.example.checkerapp.api.LoginDataSource
import com.example.checkerapp.model.LoggedInUser


class LoginRepository(val dataSource: LoginDataSource) {

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

    fun login(passId: String, password: String): Result<LoggedInUser> {

        val result = dataSource.loginEmployee(passId, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}
