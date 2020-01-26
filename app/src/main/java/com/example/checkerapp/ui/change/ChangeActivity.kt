package com.example.checkerapp.ui.change

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.checkerapp.R
import com.example.checkerapp.model.Employee
import com.example.checkerapp.model.StatusHistory
import com.example.checkerapp.ui.register.RegisterActivityViewModel
import kotlinx.android.synthetic.main.activity_change_status.*
import kotlinx.android.synthetic.main.activity_register.*

class ChangeActivity : AppCompatActivity() {


    private lateinit var changeActivityViewModel: ChangeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_status)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        //TODO - view state
        btnChangeState.setOnClickListener{changeState()}    //change the state
    }

    private fun initViewModel() {
        changeActivityViewModel = ViewModelProviders.of(this).get(ChangeActivityViewModel::class.java)
    }

    private fun GetWorker() {

        changeActivityViewModel.getCurrentStatusByWorkerId(66366)

    }

    private fun changeState() {

        changeActivityViewModel.changeStatus(66366)

        changeActivityViewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show() //TODO geeft niet het juiste bericht dat ik wil zien.
        })


    }
}