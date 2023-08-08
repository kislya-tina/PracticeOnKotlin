package me.apps.personal_account_npo_mir.view.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import me.apps.personalaccountnpomir.R

class SearchDevicesActivity : AppCompatActivity(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_devices)

        textView = findViewById(R.id.textEnterSerialNumber)
        editText = findViewById(R.id.searchDevicesEditText)
        editText.setOnClickListener(this)

        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if(view == backButton){
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var backButton: AppCompatButton
}