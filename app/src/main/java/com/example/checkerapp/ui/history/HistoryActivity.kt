package com.example.checkerapp.ui.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.checkerapp.R
import com.example.checkerapp.adapter.HistoryAdapter
import com.example.checkerapp.model.StatusHistory
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.navigation_bar.*

class HistoryActivity : AppCompatActivity() {

    private val statuses = arrayListOf<StatusHistory>()
    private val historyAdapter = HistoryAdapter(statuses)
    private lateinit var historyViewModel: HistoryActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        initViews()
        initViewModel()
    }

    private fun initViews() {
        rvHistory.layoutManager = LinearLayoutManager(this@HistoryActivity, RecyclerView.VERTICAL,
            false)
        rvHistory.adapter = historyAdapter
        navigate()
    }

    private fun initViewModel() {
        historyViewModel = ViewModelProviders.of(this).get(HistoryActivityViewModel::class.java)
        historyViewModel.getStatusHistory(66366, 10)
        historyViewModel.history.observe(this, Observer {
                statuses.clear()
                statuses.addAll(it)
                historyAdapter.notifyDataSetChanged()
        })

        if(statuses.isEmpty()) {
            historyViewModel.error.observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            })
        }

    }

    private fun navigate(){
        btnChangeStatus.setOnClickListener { openChangeStatus() }
        btnCurrentStatus.setOnClickListener { openCurrentStatus() }
        btnHistory.setOnClickListener { openHistory() }
    }

    private fun openHistory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun openCurrentStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun openChangeStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
