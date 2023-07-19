package me.apps.personal_account_npo_mir.view.main.instruments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.fragment.app.FragmentActivity
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
    OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrument)

        archiveButton = findViewById(R.id.archiveButton)
        archiveButton.setOnClickListener(this)
        diagnosticButton = findViewById(R.id.diagnosticButton)
        diagnosticButton.setOnClickListener(this)
        transmittalButton = findViewById(R.id.transButton)
        transmittalButton.setOnClickListener(this)
        informationButton = findViewById(R.id.informationButton)
        informationButton.setOnClickListener(this)

        adapter = DeviceAdapter(this)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "${(position + 1)}"
        }.attach()

        presenter.onViewCreated(this)
    }


    override fun onClick(view: View?) {
        if (view === archiveButton) {
            startArchiveActivity()
        }
        if (view === diagnosticButton) {
            startDiagnosticActivity()
        }
        if (view === transmittalButton) {
            startTransmittalActivity()
        }
        if (view === informationButton) {
            startInformationActivity()
        }
    }

    override fun refreshItems() {

    }

    override fun setHeader(header: String) {

    }

    override fun startArchiveActivity() {
        presenter.onStartArchiveActivity()
        val intent = Intent(this, ArchiveActivity::class.java)
        startActivity(intent)
    }

    override fun startDiagnosticActivity() {
        presenter.onStartDiagnosticActivity()
        val intent = Intent(this, DiagnosticActivity::class.java)
        startActivity(intent)
    }

    override fun startTransmittalActivity() {
        presenter.onStartTransmittalActivity()
        val intent = Intent(this, TransmittalActivity::class.java)
        startActivity(intent)
    }

    override fun startInformationActivity() {
        presenter.onStartInformationActivity()
        val intent = Intent(this, InformationActivity::class.java)
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()

        archiveButton.setOnClickListener(null)
        diagnosticButton.setOnClickListener(null)
        transmittalButton.setOnClickListener(null)
        informationButton.setOnClickListener(null)

        presenter.onDestroy()
    }

    private lateinit var archiveButton: Button
    private lateinit var diagnosticButton: Button
    private lateinit var transmittalButton: Button
    private lateinit var informationButton: Button
    private lateinit var adapter: DeviceAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private var presenter = InstrumentPresenter()
}
