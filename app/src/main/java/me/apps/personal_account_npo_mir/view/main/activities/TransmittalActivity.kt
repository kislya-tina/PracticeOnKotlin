package me.apps.personal_account_npo_mir.view.main.activities

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import me.apps.personal_account_npo_mir.di.App
import me.apps.personalaccountnpomir.R

class TransmittalActivity:  Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transmittal_activity)

        sumTextView = this.findViewById(R.id.indicationOfSumTextView)
        tariff1IndicationsTextView = this.findViewById(R.id.indicationFirstTariffTextView)
        tariff2IndicationsTextView = this.findViewById(R.id.indicationSecondTextView)
        tariff3IndicationsTextView = this.findViewById(R.id.indicationThirdTextView)
        tariff4IndicationsTextView = this.findViewById(R.id.indicationFourthTextView)

    }


    private lateinit var sumTextView : TextView
    private lateinit var tariff1IndicationsTextView: TextView
    private lateinit var tariff2IndicationsTextView: TextView
    private lateinit var tariff3IndicationsTextView: TextView
    private lateinit var tariff4IndicationsTextView: TextView

}