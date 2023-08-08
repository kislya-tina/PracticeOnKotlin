package me.apps.personal_account_npo_mir.view.main.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import me.apps.personalaccountnpomir.R

class OnDateArchiveActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_date_archive)

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if(view == backButton){
            onBackPressedDispatcher.onBackPressed()
            }
        }

    private lateinit var backButton: Button


}




