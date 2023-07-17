package me.apps.personal_account_npo_mir.view.login

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.animation.doOnEnd
import me.apps.personalaccountnpomir.R
import kotlin.math.roundToInt

class ButtonLoading(view: View) {
    val layout = view as LinearLayout
    private val progressBar: ProgressBar = view.findViewById(R.id.btn_loading_progressbar)
/*
    private val loginText = view.findViewById<TextView>(R.id.login_text_view)
*/
    private val icfail = view.findViewById<ImageView>(R.id.fail_view)

    fun setLoading(){
        layout.isEnabled = false
/*
        loginText.visibility = View.GONE
*/
        progressBar.visibility = View.VISIBLE
    }

    fun reset(){
/*
        loginText.visibility = View.VISIBLE
*/
        progressBar.visibility = View.GONE
        icfail.visibility = View.GONE

        layout.background.clearColorFilter()
        layout.isEnabled = true
    }

}