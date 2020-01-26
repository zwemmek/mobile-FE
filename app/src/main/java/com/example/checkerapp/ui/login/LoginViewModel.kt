package com.example.checkerapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.example.checkerapp.repository.LoginRepository
import com.example.checkerapp.repository.Result

import com.example.checkerapp.R

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(passId: String, password: String) {

        val result = loginRepository.login(passId, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(passId = result.data.passId))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(passId: String, password: String) {
        if (!isPassIdValid(passId)) {
            _loginForm.value = LoginFormState(passIdError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }


    private fun isPassIdValid(passId: String): Boolean {
        return if (passId.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(passId).matches()
        } else {
            passId.isNotBlank()
        }
    }


    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
