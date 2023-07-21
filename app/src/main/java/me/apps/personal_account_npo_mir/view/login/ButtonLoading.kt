package me.apps.personal_account_npo_mir.view.login

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.animation.doOnEnd
import me.apps.personalaccountnpomir.R

class ButtonLoading(view: View) {
    val layout = view as LinearLayoutCompat
    private val progressBar: ProgressBar = view.findViewById(R.id.btn_loading_progressbar)
    private val loginText = view.findViewById<TextView>(R.id.login_text_view)
    private val ic_success = view.findViewById<ImageView>(R.id.fail_view)

    fun setLoading() {
        layout.isEnabled = false
        loginText.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        ic_success.visibility = View.GONE
    }

    fun setState(isSuccess: Boolean, onAnimationEnd: () -> Unit) {
        val bgAnim = ObjectAnimator.ofFloat(0f, 1f).setDuration(500L)
        bgAnim.start()
        bgAnim.doOnEnd {
            if (isSuccess) {
                flipProgressBar(R.drawable.ic_done) { if (it) onAnimationEnd() }
            }
            else {
                flipProgressBar(R.drawable.ic_fail) { if (it) onAnimationEnd() }
            }
        }
    }




    private fun flipProgressBar(img: Int, isEnded: (Boolean) -> Unit) {
        ic_success.setImageResource(img)
        val flip1 = ObjectAnimator.ofFloat(progressBar, "scaleX", 1f, 0f)
        val flip2 = ObjectAnimator.ofFloat(ic_success, "scaleX", 0f, 1f)
        flip1.duration = 400
        flip2.duration = 400
        flip1.interpolator = DecelerateInterpolator()
        flip2.interpolator = AccelerateDecelerateInterpolator()
        flip1.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                progressBar.visibility = View.GONE
                ic_success.visibility = View.VISIBLE
                flip2.start()
            }
        })
        flip1.start()
        flip2.doOnEnd { isEnded(true) }
    }


    fun reset() {
        loginText.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        ic_success.visibility = View.GONE
        layout.isEnabled = true
    }
}