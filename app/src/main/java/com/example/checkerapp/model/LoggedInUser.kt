package com.example.checkerapp.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val passId: String,
    val password: String
)
