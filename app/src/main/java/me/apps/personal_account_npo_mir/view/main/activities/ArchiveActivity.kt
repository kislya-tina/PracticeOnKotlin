package me.apps.personal_account_npo_mir.view.main.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.ArchivePresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IArchiveView
import me.apps.personal_account_npo_mir.view.main.dates.DatesRowAdapter
import me.apps.personalaccountnpomir.R

class ArchiveActivity : AppCompatActivity(), IArchiveView, OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

        recyclerView = findViewById<RecyclerView?>(R.id.archiveRecycler)
            .apply {
                adapter = this@ArchiveActivity.adapter
            }
        presenter.onViewCreated(this)

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        transferButton = findViewById(R.id.transfer_button)
        transferButton.setOnClickListener(this)

        fromDate = findViewById(R.id.fromDate)

        toDate = findViewById(R.id.toDate)
    }

    override fun onClick(view: View?) {
        if (view === backButton) {
            onBackPressedDispatcher.onBackPressed()
        }
        if(view === transferButton){
            presenter.onTransferButtonClick(fromDate.text.toString(), toDate.text.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun setHeader(header: String) {
        supportActionBar?.title = header
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun refreshItems() {
        adapter.notifyDataSetChanged()
    }

    override fun startItemActivity() {
        val intent = Intent(this, OnDateArchiveActivity::class.java)
        startActivity(intent)
    }

    private lateinit var recyclerView: RecyclerView
    private val presenter = ArchivePresenter()
    private val adapter = DatesRowAdapter(presenter)
    private lateinit var backButton: Button
    private lateinit var transferButton: Button
    private lateinit var fromDate: EditText
    private lateinit var toDate: EditText

}