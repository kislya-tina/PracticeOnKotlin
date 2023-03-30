package me.apps.personal_account_npo_mir.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.apps.personal_account_npo_mir.presentation.main.InstrumentPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IMainView
import me.apps.personal_account_npo_mir.view.main.activities.ArchiveActivity
import me.apps.personal_account_npo_mir.view.main.activities.DiagnosticActivity
import me.apps.personal_account_npo_mir.view.main.activities.InformationActivity
import me.apps.personal_account_npo_mir.view.main.activities.TransmittalActivity
import me.apps.personalaccountnpomir.R


private const val NUM_PAGES = 5

class InstrumentActivity : FragmentActivity(),
    IMainView,
    OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrument)

        presenter.onViewCreated(this)

        button = findViewById(R.id.archiveButton)
        button.setOnClickListener(this)
        button1 = findViewById(R.id.diagnosticButton)
        button1.setOnClickListener(this)
        button2 = findViewById(R.id.transButton)
        button2.setOnClickListener(this)
        button3 = findViewById(R.id.informationButton)
        button3.setOnClickListener(this)

        adapter = DeviceAdapter(this)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "${(position + 1)}"
        }.attach()

    }


        override fun onClick(view: View?) {
//        presenter.onButtonClick(view)
            if (view === button) {
                startAnotherActivity(ArchiveActivity())
            }
            if (view === button1) {
                startAnotherActivity(DiagnosticActivity())
            }
            if (view === button2) {
                startAnotherActivity(TransmittalActivity())
            }
            if (view === button3) {
                startAnotherActivity(InformationActivity())
            }
        }

        override fun setHeader(header: String) {
        }

        override fun refreshItems() {
        }

        override fun startAnotherActivity(activity: Activity) {
            val intent = Intent(this, activity::class.java)
            startActivity(intent)
        }

        override fun onDestroy() {
            super.onDestroy()
            button.setOnClickListener(null)
        }

        private lateinit var button: Button
        private lateinit var button1: Button
        private lateinit var button2: Button
        private lateinit var button3: Button
        private lateinit var adapter: DeviceAdapter
        private lateinit var viewPager: ViewPager2
        private lateinit var tabLayout: TabLayout
        private var presenter = InstrumentPresenter()

    }
