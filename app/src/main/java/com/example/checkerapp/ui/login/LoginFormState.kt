package com.example.checkerapp.ui.login

/**
 * Data validation state of the login form.
 */
data class LoginFormState(
    val passIdError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)
