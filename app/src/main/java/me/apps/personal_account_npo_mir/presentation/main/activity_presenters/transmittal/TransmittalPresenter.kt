package me.apps.personal_account_npo_mir.presentation.main.activity_presenters.transmittal

import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.presentation.abstraction.ISupportWarningDialogPresenter
import me.apps.personal_account_npo_mir.view.abstractions.dialogs.IWarningDialogView
import me.apps.personal_account_npo_mir.view.abstractions.main.ITransmittalView
import me.apps.personalaccountnpomir.R

class TransmittalPresenter : IPresenter<ITransmittalView>,
    ISupportWarningDialogPresenter{

    override fun onViewCreated(view: ITransmittalView) {
        this.view = view
    }

    fun onSummaryTextChanged(summary : String){
        this.summary = summary
    }

    fun onTariff1TextChanged(tariff1 : String){
        this.tariff1 = tariff1
    }

    fun onTariff2TextChanged(tariff2 : String){
        this.tariff2 = tariff2
    }

    fun onTariff3TextChanged(tariff3 : String){
        this.tariff3 = tariff3
    }

    fun onTariff4TextChanged(tariff4 : String){
        this.tariff4 = tariff4
    }

    fun onClickHandOverButton() {
        var success = true
        if (summary.isBlank()) {
            success = false
            view?.setSummaryBackground(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setSummaryBackground(R.drawable.rec_trans)
        }
        if (tariff1.isBlank()) {
            success = false
            view?.setTariff1Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff1Background(R.drawable.rec_trans)
        }

        if (tariff2.isBlank()) {
            success = false
            view?.setTariff2Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff2Background(R.drawable.rec_trans)
        }

        if (tariff3.isBlank()) {
            success = false
            view?.setTariff3Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff3Background(R.drawable.rec_trans)
        }

        if (tariff4.isBlank()) {
            success = false
            view?.setTariff4Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff4Background(R.drawable.rec_trans)
        }
// TODO: сделать подачу для сервера в виде жсон и параметры показаний
        /*if(success && App.measureService.putMeasure(
                measureID,
                userToken,
                summary,
                tariff1,
                tariff2,
                tariff3,
                tariff4
            )){

            else{
                exception
            }
            */
        if (success) {
            // TODO: we need to create new service for measures
            view?.showDialog()
        }
    }

    override fun onDestroy() {
        this.view = null
        summary = ""
        tariff1 = ""
        tariff2 = ""
        tariff3 = ""
        tariff4 = ""
    }

    override fun onDialogCreate(view: IWarningDialogView) {
        view.setTitle(R.string.success)
        view.setWarningMessage(R.string.well_done)
    }

    override fun onDialogDestroy() {

    }

    override fun onOkButtonClick() {

    }

    override fun onCancelButtonClick() {

    }

    private var view: ITransmittalView? = null
    private var summary: String = ""
    private var tariff1: String = ""
    private var tariff2: String = ""
    private var tariff3: String = ""
    private var tariff4: String = ""
}