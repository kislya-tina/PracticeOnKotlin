package me.apps.personal_account_npo_mir.view.login

import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import me.apps.personalaccountnpomir.R

class ButtonLoading(view: View) {
    val layout = view as LinearLayout
    val progressbar = view.findViewById<ProgressBar>(R.id.btn_loading_progressbar)
    val textview = view.findViewById<TextView>(R.id.login_text_view)

    fun setLoading(){
        layout.isEnabled = false
        textview.visibility = View.GONE
        progressbar.visibility = View.VISIBLE
    }

    fun reset(){
        textview.visibility = View.VISIBLE
        progressbar.visibility = View.GONE
    }

}