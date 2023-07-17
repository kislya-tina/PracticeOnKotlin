package me.apps.personal_account_npo_mir.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import me.apps.personalaccountnpomir.R

class OnDateArchiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_date_archive)

        backButton = findViewById(R.id.back_button)
    }


    private lateinit var backButton: Button


}


