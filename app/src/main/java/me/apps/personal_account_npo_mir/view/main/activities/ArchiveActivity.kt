package me.apps.personal_account_npo_mir.view.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.ArchivePresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IArchiveView
import me.apps.personalaccountnpomir.R

class ArchiveActivity : AppCompatActivity(), IArchiveView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_archive)

    }

    override fun setHeader(header: String) {
        TODO("Not yet implemented")
    }

    override fun refreshItems() {
        TODO("Not yet implemented")
    }

    override fun showDialog() {
        TODO("Not yet implemented")
    }

    private lateinit var recyclerView: RecyclerView
    private val presenter = ArchivePresenter()
//    private val adapter =
}