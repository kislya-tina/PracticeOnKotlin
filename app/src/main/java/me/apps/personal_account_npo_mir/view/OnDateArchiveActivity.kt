package me.apps.personal_account_npo_mir.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.apps.personalaccountnpomir.R

class OnDateArchiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_date_archive)
        val arguments = intent.extras
        date = arguments?.getLong("date") as Long
    }

    private var date : Long = 0
}