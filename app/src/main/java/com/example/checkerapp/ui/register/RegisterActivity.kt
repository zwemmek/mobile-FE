package com.example.checkerapp.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.checkerapp.R
import com.example.checkerapp.model.Employee
import com.example.checkerapp.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel: RegisterActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initViews()
    }

    private fun initViews() {
        btnConfirm.setOnClickListener{register()}
    }

    private fun checkForm(): Boolean {
        return !(etEmployeeID.text.isNullOrBlank() ||
                etFirstName.text.isNullOrBlank() ||
                etLastName.text.isNullOrBlank() ||
                etPassID.text.isNullOrBlank()   ||
                etPassword.text.isNullOrBlank() ||
                etRepeatPassword.text.isNullOrBlank())
    }

    private fun register() {
        if (checkForm()) {

            val newEmployee = Employee(
                employeeId = etEmployeeID.text.toString(),
                firstName = etFirstName.text.toString(),
                lastName = etLastName.text.toString(),
                passId = etPassID.text.toString(),
                password = etPassword.text.toString()
            )

                registerViewModel = ViewModelProviders.of(this).get(RegisterActivityViewModel::class.java)
                registerViewModel.registerEmployee(newEmployee)

                if (registerViewModel.authResponse) {
                    Toast.makeText(this, "it worked", Toast.LENGTH_SHORT).show()
                    //TODO deze toast omzetten naar de response van de server.

                    startActivity(
                        Intent(this@RegisterActivity,
                            LoginActivity::class.java)
                    )
                }
                else {
                    registerViewModel.error.observe(this, Observer {
                        Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                    })
                }
        }
        else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
        }
    }
}
