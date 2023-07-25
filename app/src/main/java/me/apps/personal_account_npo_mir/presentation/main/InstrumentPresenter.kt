package me.apps.personal_account_npo_mir.presentation.main

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IMainView
import me.apps.personal_account_npo_mir.view.abstractions.main.IMeterListViewItem

class InstrumentPresenter : IPresenter<IMainView>,
    IServerRequestResultListener<GetMetersRequestResult> {
    /**
     * Колбэк при создании View
     */
    override fun onViewCreated(view: IMainView) {
        this.view = view
        val username = App.userDataService.username
        val token = App.userDataService.token
        view.setHeader(username)
        App.metersService.getMeters(token, this)
    }

    /**
     * Колбэк при завершении работы презентера
     */
    override fun onRequestSuccess(result: GetMetersRequestResult) {
        meters = result.toString()
    }

    override fun onRequestFail(message: ErrorCode) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        view = null
    }

    /**
     * Колбэк при создании элемента списка
     * @param view Представление элемента списка счетчиков\
     * @param position Индекс позиции, по которой будет отображен элемент
     */

    fun onBindViewItem(view: IMeterListViewItem, position: Int) {
        //view.setName(meters[position].name)
        //view.setIndications(meters[position].serialNumber.toString())
    }

    /**
     * Колбэк при нажатии на кнопку "Архив показаний"
     */
    fun onArchiveButtonClick() {
        view?.startArchiveActivity()
    }

    /**
     * Колбэк при нажатии на кнопку "Диагностика"
     */
    fun onDiagnosticButtonClick() {
        view?.startDiagnosticActivity()
    }

    /**
     * Колбэк при нажатии на кнопку "Передача показаний"
     */
    fun onTransmittalButtonClick() {
        view?.startTransmittalActivity()
    }

    /**
     * Колбэк при нажатии на кнопку "Информация"
     */
    fun onInformationButtonClick() {
        view?.startInformationActivity()
    }
    /**
     * Кол-во элементов в списке
     */
    //val itemsCount
    //  get() = meters.size

    private lateinit var meters: String
    private var view: IMainView? = null
    private var meterID: Int = 0
}

