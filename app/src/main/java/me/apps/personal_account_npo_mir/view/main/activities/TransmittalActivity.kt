package me.apps.personal_account_npo_mir.view.main.activities

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import me.apps.personal_account_npo_mir.di.App
import me.apps.personalaccountnpomir.R

class TransmittalActivity:  Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transmittal_activity)

        sumTextView = this.findViewById(R.id.indicationOfSumTextView)
        tariff1IndicationsTextView = this.findViewById(R.id.indicationFirstTariffTextView)
        tariff2IndicationsTextView = this.findViewById(R.id.indicationSecondTextView)
        tariff3IndicationsTextView = this.findViewById(R.id.indicationThirdTextView)
        tariff4IndicationsTextView = this.findViewById(R.id.indicationFourthTextView)

        sumTextView.text = sumIndications
        tariff1IndicationsTextView.text = tariff1Indications
        tariff2IndicationsTextView.text = tariff2Indications
        tariff3IndicationsTextView.text = tariff3Indications
        tariff4IndicationsTextView.text = tariff4Indications
    }

    private var sumIndications :
            String = "   " + App.metersService.getLastMeasures(123, "123")["summary"].toString()

    private var tariff1Indications :
            String = "   " + App.metersService.getLastMeasures(123, "123")["tariff1"].toString()
    private var tariff2Indications :
            String = "   " + App.metersService.getLastMeasures(123, "123")["tariff2"].toString()
    private var tariff3Indications :
            String = "   " + App.metersService.getLastMeasures(123, "123")["tariff3"].toString()
    private var tariff4Indications :
            String = "   " + App.metersService.getLastMeasures(123, "123")["tariff4"].toString()

    private lateinit var sumTextView : TextView
    private lateinit var tariff1IndicationsTextView: TextView
    private lateinit var tariff2IndicationsTextView: TextView
    private lateinit var tariff3IndicationsTextView: TextView
    private lateinit var tariff4IndicationsTextView: TextView

}
//как в рег активити
//на изменение textEdit в поиске
