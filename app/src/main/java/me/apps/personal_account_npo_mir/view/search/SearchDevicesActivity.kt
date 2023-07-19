package me.apps.personal_account_npo_mir.view.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import me.apps.personalaccountnpomir.R

class SearchDevicesActivity : AppCompatActivity(), OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_devices)

        textView = findViewById(R.id.textEnterSerialNumber)
        editText = findViewById(R.id.searchDevicesEditText)
        editText.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
    }

    private lateinit var textView: TextView
    private lateinit var editText: EditText
}