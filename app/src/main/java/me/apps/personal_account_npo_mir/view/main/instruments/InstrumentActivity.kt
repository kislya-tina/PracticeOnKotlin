package me.apps.personal_account_npo_mir.view.main.instruments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.apps.personal_account_npo_mir.presentation.main.InstrumentPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IMainView
import me.apps.personal_account_npo_mir.view.main.activities.ArchiveActivity
import me.apps.personal_account_npo_mir.view.main.activities.DiagnosticActivity
import me.apps.personal_account_npo_mir.view.main.activities.InformationActivity
import me.apps.personal_account_npo_mir.view.main.activities.TransmittalActivity
import me.apps.personal_account_npo_mir.view.search.SearchDevicesActivity
import me.apps.personalaccountnpomir.R

class InstrumentActivity : AppCompatActivity(),
    IMainView,
    OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrument)

        adapter = DeviceAdapter(this)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "${(position + 1)}"
        }.attach()

        addDevicesButton = findViewById(R.id.addDevicesBtn)
        addDevicesButton.setOnClickListener(this)

        archiveButton = this.findViewById(R.id.archiveButton)
        diagnosticButton = this.findViewById(R.id.diagnosticButton)
        transmittalButton = this.findViewById(R.id.transButton)
        informationButton = this.findViewById(R.id.informationButton)

        archiveButton.setOnClickListener(this)
        diagnosticButton.setOnClickListener(this)
        transmittalButton.setOnClickListener(this)
        informationButton.setOnClickListener(this)

        presenter.onViewCreated(this)
    }


    override fun onClick(view: View?) {
        if (view === addDevicesButton) {
            presenter.onAddDevicesButtonClick()
        }
        if (view === archiveButton) {
            presenter.onArchiveButtonClick()
        }
        if (view === diagnosticButton) {
            presenter.onDiagnosticButtonClick()
        }
        if (view === transmittalButton) {
            presenter.onTransmittalButtonClick()
        }
        if (view === informationButton) {
            presenter.onInformationButtonClick()
        }
    }

    override fun startSearchDevicesActivity() {
        val intent = Intent(this, SearchDevicesActivity::class.java)
        startActivity(intent)
    }


    override fun refreshItems() {

    }

    override fun setHeader(header: String) {

    }

    override fun startArchiveActivity() {
        val intent = Intent(this, ArchiveActivity::class.java)
        startActivity(intent)
    }

    override fun startDiagnosticActivity() {
        val intent = Intent(this, DiagnosticActivity::class.java)
        startActivity(intent)
    }

    override fun startTransmittalActivity() {
        val intent = Intent(this, TransmittalActivity::class.java)
        startActivity(intent)
    }

    override fun startInformationActivity() {
        val intent = Intent(this, InformationActivity::class.java)
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private lateinit var adapter: DeviceAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var addDevicesButton: AppCompatButton
    private lateinit var archiveButton: Button
    private lateinit var diagnosticButton: Button
    private lateinit var transmittalButton: Button
    private lateinit var informationButton: Button

    private var presenter = InstrumentPresenter()
}

