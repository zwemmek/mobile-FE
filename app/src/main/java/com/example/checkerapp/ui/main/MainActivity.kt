package com.example.checkerapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.checkerapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainViewModel.getEmployeeByPassId(5012)


        mainViewModel.employee.observe(this, Observer { employee ->
            if (employee != null) {
                tvEmployeeId.text = employee.employeeId
                tvFirstName.text = employee.firstName
                tvLastName.text = employee.lastName
                tvPassId.text = employee.passId
            }
        })

        mainViewModel.error.observe(this, Observer {
                //waardes toekennen
        })
    }

}
