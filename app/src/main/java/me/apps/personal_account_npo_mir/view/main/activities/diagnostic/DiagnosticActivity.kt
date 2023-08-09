package me.apps.personal_account_npo_mir.view.main.activities.diagnostic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.DiagnosticPresenter
import me.apps.personalaccountnpomir.R

class DiagnosticActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostic)
        recyclerView = findViewById<RecyclerView?>(R.id.recyclerView)
            .apply {
                adapter = this@DiagnosticActivity.adapter
            }

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view === backButton){
            onBackPressedDispatcher.onBackPressed()        }
    }

    private lateinit var backButton: Button
    private lateinit var recyclerView: RecyclerView
    private val presenter = DiagnosticPresenter()
    private val adapter = DiagnosticItemAdapter(presenter)

}