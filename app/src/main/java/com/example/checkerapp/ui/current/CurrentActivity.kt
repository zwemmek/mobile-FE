package com.example.checkerapp.ui.current

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.checkerapp.R
import com.example.checkerapp.ui.change.ChangeActivity
import com.example.checkerapp.ui.history.HistoryActivity
import kotlinx.android.synthetic.main.navigation_bar.*

class CurrentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current)

        initViews()
    }

    private fun initViews() {
        navigate()
    }

    private fun navigate(){
        btnChangeStatus.setOnClickListener { openChangeStatus() }
        btnCurrentStatus.setOnClickListener { openCurrentStatus() }
        btnHistory.setOnClickListener { openHistory() }
    }

    private fun openHistory() {
        btnHistory.setOnClickListener {startActivity(
            Intent(this@CurrentActivity,
                HistoryActivity::class.java)
        )}
    }

    private fun openCurrentStatus() {
        btnCurrentStatus.setOnClickListener {startActivity(
            Intent(this@CurrentActivity,
                CurrentActivity::class.java)
        )}}

    private fun openChangeStatus() {
        btnChangeStatus.setOnClickListener {startActivity(
            Intent(this@CurrentActivity,
                ChangeActivity::class.java)
        )} }
}
