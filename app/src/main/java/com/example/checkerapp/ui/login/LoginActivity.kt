package com.example.checkerapp.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Toast

import com.example.checkerapp.R
import com.example.checkerapp.model.LoggedInUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            initViews()
        }

    private fun initViews() {
        btnLogin.setOnClickListener{loginEmployee()}
    }

    private fun loginEmployee() {
        val user = LoggedInUser(
            passId = passId.text.toString(),
            password = password.text.toString()
        )

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.login(user)



            loginViewModel.serverResponse.observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            })


        loginViewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })


        }



    }

