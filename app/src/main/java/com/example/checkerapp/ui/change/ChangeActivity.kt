package com.example.checkerapp.ui.change

import android.graphics.Color
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
        btnChangeState.setOnClickListener{ GetWorker()}    //change the state changeState();
    }

    private fun initViewModel() {
        changeActivityViewModel = ViewModelProviders.of(this).get(ChangeActivityViewModel::class.java)
    }

    private fun GetWorker() {

        val status = "vis" // TODO dit is tijdelijk

        changeActivityViewModel.getCurrentStatusByWorkerId(66366)

        if (status == "in") {
            ivStatusPlaceHolder.setBackgroundResource(R.drawable.vinkje)
            tvCurrentStatusText.text = getString(R.string.checked_out)
            clChangeStatus.setBackgroundColor(getResources().getColor(R.color.checked_in))
            btnChangeState.setBackgroundColor(getResources().getColor(R.color.colorAccent))
            btnChangeState.text = getString(R.string.check_me_out)
            // and more color changes
        }
        else if ( status == "out") {
            val a = "placeholder"
            ivStatusPlaceHolder.setBackgroundResource(R.drawable.kruis)
            tvCurrentStatusText.text = getString(R.string.checked_in)
            clChangeStatus.setBackgroundColor(getResources().getColor(R.color.checked_out))
            btnChangeState.setBackgroundColor(getResources().getColor(R.color.grayed_out))
            btnChangeState.text = getString(R.string.check_me_in)
            // change colors to red-ish
        }
        else {
            Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_SHORT).show()
        }

    }

    private fun changeState() {

        changeActivityViewModel.changeStatus(66366)

        changeActivityViewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            //TODO geeft niet het juiste bericht dat ik wil zien, geeft namelijk de error ipv de response.
        })


    }
}