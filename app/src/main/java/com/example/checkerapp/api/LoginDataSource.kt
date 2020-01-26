package com.example.checkerapp.api

import com.example.checkerapp.model.LoggedInUser
import com.example.checkerapp.repository.Result
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun loginEmployee(passId: String, password: String): Result<LoggedInUser> {
        try {
            val User = LoggedInUser("5012", "tester")
            return Result.Success(User)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
    }
}

