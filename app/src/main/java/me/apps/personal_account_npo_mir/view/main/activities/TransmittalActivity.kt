package me.apps.personal_account_npo_mir.view.main.activities

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.transmittal.TransmittalPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.ITransmittalView
import me.apps.personal_account_npo_mir.view.dialogs.WarningDialogFragment
import me.apps.personalaccountnpomir.R

class

TransmittalActivity:  AppCompatActivity(),
            OnClickListener,
            ITransmittalView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transmittal)

        handOverButton = this.findViewById(R.id.handOverButton)
        handOverButton.setOnClickListener(this)


        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        sumTextView = this.findViewById(R.id.indicationOfSumTextView)
        tariff1IndicationsTextView = this.findViewById(R.id.indicationFirstTariffTextView)
        tariff2IndicationsTextView = this.findViewById(R.id.indicationSecondTextView)
        tariff3IndicationsTextView = this.findViewById(R.id.indicationThirdTextView)
        tariff4IndicationsTextView = this.findViewById(R.id.indicationFourthTextView)

        presenter.onViewCreated(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        handOverButton.setOnClickListener(null)
        presenter.onDestroy()
    }

    override fun onClick(view: View?) {
        if(view === handOverButton){
            presenter.onSummaryTextChanged(sumTextView.text.toString())
            presenter.onTariff1TextChanged(tariff1IndicationsTextView.text.toString())
            presenter.onTariff2TextChanged(tariff2IndicationsTextView.text.toString())
            presenter.onTariff3TextChanged(tariff3IndicationsTextView.text.toString())
            presenter.onTariff4TextChanged(tariff4IndicationsTextView.text.toString())
            presenter.onClickHandOverButton()
        }
        if (view === backButton){
            onBackPressedDispatcher.onBackPressed()        }
    }

    override fun showDialog() {
        val dialog = WarningDialogFragment(presenter)
        dialog.show(supportFragmentManager, "")
    }

    override fun setSummaryBackground(resourceID: Int) {
        sumTextView.setBackgroundResource(resourceID)
    }

    override fun setTariff1Background(resourceID: Int) {
        tariff1IndicationsTextView.setBackgroundResource(resourceID)
    }

    override fun setTariff2Background(resourceID: Int) {
        tariff2IndicationsTextView.setBackgroundResource(resourceID)
    }

    override fun setTariff3Background(resourceID: Int) {
        tariff3IndicationsTextView.setBackgroundResource(resourceID)
    }

    override fun setTariff4Background(resourceID: Int) {
        tariff4IndicationsTextView.setBackgroundResource(resourceID)
    }

    private lateinit var sumTextView : AppCompatEditText
    private lateinit var tariff1IndicationsTextView: AppCompatEditText
    private lateinit var tariff2IndicationsTextView: AppCompatEditText
    private lateinit var tariff3IndicationsTextView: AppCompatEditText
    private lateinit var tariff4IndicationsTextView: AppCompatEditText
    private lateinit var handOverButton: Button
    private lateinit var backButton: Button
    private var presenter = TransmittalPresenter()
}
