package me.apps.personal_account_npo_mir.view.main.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.transmittal.TransmittalDialogFragment
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.transmittal.TransmittalPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.ITransmittalView
import me.apps.personalaccountnpomir.R

class TransmittalActivity:  Activity(),
            OnClickListener,
            ITransmittalView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transmittal_activity)

        handOverButton = this.findViewById(R.id.handOverButton)
        handOverButton.setOnClickListener(this)

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

        presenter.onViewCreated(this)
    }

    override fun onClick(view: View?) {
        if(view === handOverButton){
            presenter.onClickHandOverButton()
        }
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
    private lateinit var handOverButton: Button
    private var presenter = TransmittalPresenter()
}
//как в рег активити
//на изменение textEdit в поиске
