package me.apps.personal_account_npo_mir.view.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import me.apps.personalaccountnpomir.R

class DiagnosticActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostic)

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
    }

    private lateinit var backButton: Button
}