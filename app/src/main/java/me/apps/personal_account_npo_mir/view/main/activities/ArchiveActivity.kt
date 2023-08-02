package me.apps.personal_account_npo_mir.view.main.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
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
        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)
        presenter.onViewCreated(this)
    }

    override fun onClick(view: View?) {
        if (view === backButton) {
            onBackPressedDispatcher.onBackPressed()
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

    // getMeasure(deviceID, from, to, 1, 10, token)

    override fun startItemActivity(date: Long) {
        val intent = Intent(this, OnDateArchiveActivity::class.java).apply {
            intent.putExtra("date", date)
        }
        startActivity(intent)
    }

    private lateinit var recyclerView: RecyclerView
    private val presenter = ArchivePresenter()
    private val adapter = DatesRowAdapter(presenter)
    private lateinit var backButton: Button

}