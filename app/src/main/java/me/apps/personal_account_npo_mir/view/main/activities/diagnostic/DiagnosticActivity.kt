package me.apps.personal_account_npo_mir.view.main.activities.diagnostic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.DiagnosticPresenter
import me.apps.personalaccountnpomir.R

class DiagnosticActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostic)
        recyclerView = findViewById<RecyclerView?>(R.id.recyclerView)
            .apply {
                adapter = this@DiagnosticActivity.adapter
            }
    }

    private lateinit var recyclerView: RecyclerView
    private val presenter = DiagnosticPresenter()
    private val adapter = DiagnosticItemAdapter(presenter)

}