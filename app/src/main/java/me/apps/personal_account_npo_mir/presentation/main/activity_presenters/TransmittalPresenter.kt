package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.presentation.abstraction.ISupportWarningDialogPresenter
import me.apps.personal_account_npo_mir.view.abstractions.dialogs.IWarningDialogView
import me.apps.personal_account_npo_mir.view.abstractions.main.ITransmittalView
import me.apps.personalaccountnpomir.R

class TransmittalPresenter : IPresenter<ITransmittalView>,
    ISupportWarningDialogPresenter {

    /**
     * Колбэк при создании View
     */
    override fun onViewCreated(view: ITransmittalView) {
        this.view = view
    }

    /**
     * Колбэк при изменении текста в поле "summaryMeasure"
     */
    fun onSummaryTextChanged(summary: String) {
        this.summary = summary
    }

    /**
     * Колбэк при изменении текста в поле "tariff1"
     */
    fun onTariff1TextChanged(tariff1: String) {
        this.tariff1 = tariff1
    }

    /**
     * Колбэк при изменении текста в поле "tariff2"
     */
    fun onTariff2TextChanged(tariff2: String) {
        this.tariff2 = tariff2
    }

    /**
     * Колбэк при изменении текста в поле "tariff3"
     */
    fun onTariff3TextChanged(tariff3: String) {
        this.tariff3 = tariff3
    }

    /**
     * Колбэк при изменении текста в поле "tariff4"
     */
    fun onTariff4TextChanged(tariff4: String) {
        this.tariff4 = tariff4
    }

    /**
     * Колбэк при нажатии на кнопку "handOverButton"
     */
    fun onClickHandOverButton() {
        var success = true
        //Проверка текста в поле "summaryMeasure"
        if (summary.isBlank()) {
            success = false
            view?.setSummaryBackground(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setSummaryBackground(R.drawable.rec_trans)
        }
        //Проверка текста в поле "tariff1"
        if (tariff1.isBlank()) {
            success = false
            view?.setTariff1Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff1Background(R.drawable.rec_trans)
        }
        //Проверка текста в поле "tariff2"
        if (tariff2.isBlank()) {
            success = false
            view?.setTariff2Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff2Background(R.drawable.rec_trans)
        }
        //Проверка текста в поле "tariff3"
        if (tariff3.isBlank()) {
            success = false
            view?.setTariff3Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff3Background(R.drawable.rec_trans)
        }
        //Проверка текста в поле "tariff4"
        if (tariff4.isBlank()) {
            success = false
            view?.setTariff4Background(R.drawable.ic_warning_frame_trans)
        } else {
            view?.setTariff4Background(R.drawable.rec_trans)
        }
        /*if (success) {
            App.measureService.putMeasure(measureID, userToken,
                Measure(summary, tariff1, tariff2, tariff3, tariff4, timestamp))
        }
        } else {
//            exception
        }
*/
        if (success) {
            // TODO: we need to create new service for measures
            view?.showDialog()
        }

    }

    /**
     * Колбэк при завершении работы презентера
     */
    override fun onDestroy() {
        this.view = null
        summary = ""
        tariff1 = ""
        tariff2 = ""
        tariff3 = ""
        tariff4 = ""
    }

    /**
     * Колбэк при создании диалога
     */
    override fun onDialogCreate(view: IWarningDialogView) {
        view.setTitle(R.string.success)
        view.setWarningMessage(R.string.well_done)
    }

    /**
     * Колбэк при завершении работы диалога
     */
    override fun onDialogDestroy() {

    }

    /**
     * Колбэк при нажатии в диалоге кнопки "Ок"
     */
    override fun onOkButtonClick() {

    }

    /**
     * Колбэк при нажатии в диалоге кнопки "Отмена"
     */
    override fun onCancelButtonClick() {

    }

    private var view: ITransmittalView? = null
    private var summary: String = ""
    private var tariff1: String = ""
    private var tariff2: String = ""
    private var tariff3: String = ""
    private var tariff4: String = ""
}
