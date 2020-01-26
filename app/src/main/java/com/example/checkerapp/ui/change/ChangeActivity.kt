package com.example.checkerapp.ui.change

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.checkerapp.R
import com.example.checkerapp.model.StatusChange
import kotlinx.android.synthetic.main.activity_change_status.*

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
        btnChangeState.setOnClickListener{changeState()}
    }

    private fun initViewModel() {
        changeActivityViewModel = ViewModelProviders.of(this).get(ChangeActivityViewModel::class.java)
        changeActivityViewModel.getCurrentStatusByEmployeeId(66366)
        changeActivityViewModel.statusHistory.observe(this, Observer { statusHistory ->
            if (statusHistory != null) {
                getWorker(statusHistory.status)
                tvCurrentStatusText.text = getString(R.string.checked_status, statusHistory.status)
            }
        })

        changeActivityViewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

    }

    private fun getWorker(statusHistory: String) {

        when (statusHistory) {
            "in" -> {
                ivStatusPlaceHolder.setBackgroundResource(R.drawable.vinkje)
                clChangeStatus.setBackgroundColor(getResources().getColor(R.color.checked_in))
                btnChangeState.setBackgroundColor(getResources().getColor(R.color.colorAccent))
                btnChangeState.text = getString(R.string.check_me_out)
                etReason.isEnabled = true
                etReason.hint = getString(R.string.reason_field_optional)
                tilReason.background = getDrawable(R.drawable.edit_text_background)
                // and more color changes
            }
            "out" -> {
                ivStatusPlaceHolder.setBackgroundResource(R.drawable.kruis)
                clChangeStatus.setBackgroundColor(getResources().getColor(R.color.checked_out))
                btnChangeState.setBackgroundColor(getResources().getColor(R.color.grayed_out))
                btnChangeState.text = getString(R.string.check_me_in)
                etReason.isEnabled = false
                etReason.hint = getString(R.string.reason_field_to_check_in)
                tilReason.background = getDrawable(R.drawable.edit_text_background_greyed)
                // change colors to red-ish
            }
            else -> Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_SHORT).show()
        }

    }

    private fun changeState() {
        val statusChange = StatusChange(
            reason = etReason.text.toString()
        )

        changeActivityViewModel.changeStatus(66366, statusChange)

        finish()
        startActivity(getIntent())

        if (changeActivityViewModel.responseSuccess) {
            Toast.makeText(this, "it worked", Toast.LENGTH_SHORT).show() //TODO hier wil ik eigenlijk de response body hebben.

        }
        else {
            changeActivityViewModel.error.observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            })
        }
    }
}