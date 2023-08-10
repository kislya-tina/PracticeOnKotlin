package me.apps.personal_account_npo_mir.view.main.dates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.OnDateArchivePresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IOnDateArchiveView
import me.apps.personalaccountnpomir.R

class OnDateArchiveActivity : AppCompatActivity() , IOnDateArchiveView, OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_date_archive)

        summary = this.findViewById(R.id.indicationOfSumTextView2)
        tariff1 = findViewById(R.id.indicationFirstTariffTextView)
        tariff2 = findViewById(R.id.indicationSecondTextView)
        tariff3 = findViewById(R.id.indicationThirdTextView)
        tariff4 = findViewById(R.id.indicationFourthTextView)

        presenter.onViewCreated(this)
        var currentMeter = App.metersService.meters[App.indexService.index]
//        val arguments = intent.extras
//        date = arguments?.getLong("date") as Long
        // TODO: Нужно передавать в эту активити дату и ID счетчика

        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

    }

    override fun setMeasure(measure : Measure) {
        summary?.text = measure.summary
        tariff1?.text = measure.tariff1
        tariff2?.text = measure.tariff2
        tariff3?.text = measure.tariff3
        tariff4?.text = measure.tariff4
    }

    override fun onClick(view: View?) {
        if(view == backButton){
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun setHeader(header : String) {
        dateTextView = findViewById(R.id.meter_name_text_view)
        dateTextView?.text = header
    }

    override fun getPosition() : Int {
        return presenter.currentClickedDate
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
//    private var date : Long? = null
    private var summary : TextView? = null
    private var tariff1 : TextView? = null
    private var tariff2 : TextView? = null
    private var tariff3 : TextView? = null
    private var tariff4 : TextView? = null
    private var dateTextView : TextView? = null
    private var presenter = OnDateArchivePresenter()
    private lateinit var backButton: Button
}