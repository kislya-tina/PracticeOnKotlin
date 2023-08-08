package me.apps.personal_account_npo_mir.view.main.activities

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import me.apps.personal_account_npo_mir.di.App
import me.apps.personalaccountnpomir.R

class InformationActivity: AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        nameTextView = findViewById(R.id.devicesNameText)
        nameTextView.text = App.metersService.meters[App.indexService.index].name

    }

    override fun onClick(view: View?) {
        if (view === backButton){
            onBackPressedDispatcher.onBackPressed()        }
    }

    private lateinit var backButton: Button
    private lateinit var nameTextView: TextView
}