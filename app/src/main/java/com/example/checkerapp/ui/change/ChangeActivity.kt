package com.example.checkerapp.ui.change

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.checkerapp.R
import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.StatusHistory
import kotlinx.android.synthetic.main.activity_change_status.*
import kotlinx.android.synthetic.main.activity_register.*

class ChangeActivity : AppCompatActivity() {


    private lateinit var changeActivityViewModel: ChangeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_status)

        initViews()
    }

    private fun initViews() {
        //TODO - view state
        btnChangeState.setOnClickListener{changeState()}    //change the state
    }
    private fun changeState() {

        changeActivityViewModel.getCurrentStatusByWorkerId(66366)

    }
}