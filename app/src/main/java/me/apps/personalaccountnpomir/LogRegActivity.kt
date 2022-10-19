package me.apps.personalaccountnpomir

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import me.apps.personalaccountnpomir.fragments.LogInFragment


class LogRegActivity : AppCompatActivity() {
    private var logCont : FrameLayout? = null
    private var regCont : FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_reg)

        logCont = findViewById(R.id.fragmentLogContainer)
        regCont = findViewById(R.id.fragmentRegContainer)



        val fm = supportFragmentManager

        var fragment: Fragment? = fm.findFragmentById(R.id.fragmentLogContainer)
        if (fragment == null) {
            fragment = LogInFragment()
            fm.beginTransaction()
                .add(R.id.fragmentLogContainer, fragment)
                .commit()
        }


    }


}