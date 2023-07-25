package me.apps.personal_account_npo_mir.view.main.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.ArchivePresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IArchiveView
import me.apps.personal_account_npo_mir.view.main.dates.DatesRowAdapter
import me.apps.personalaccountnpomir.R

class ArchiveActivity : AppCompatActivity(), IArchiveView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)
        recyclerView = findViewById<RecyclerView?>(R.id.archiveRecycler)
            .apply {
                adapter = this@ArchiveActivity.adapter
            }
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
}