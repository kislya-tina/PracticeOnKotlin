package me.apps.personal_account_npo_mir.presentation.main.instruments

import com.google.gson.Gson
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.meters.Meter
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersServerRequest
import me.apps.personal_account_npo_mir.model.services.urlForHostLoopbackInterface
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IMainView

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

    override fun onRequestSuccess(result: GetMetersRequestResult) {
        try {
            val meters:Array<Meter> = Gson().fromJson(result.meters, Array<Meter>::class.java)
            App.metersService.saveMeters(meters)
        }catch (e:Exception){
            e.printStackTrace()
        }
        // TODO: добавляем метеры в сервис, потом брать их оттуда и выбранного ID передавать в следующие активити (Архив ->  onDateArchiveActivity)
    }

    override fun onRequestFail(message: ErrorCode) {
        TODO("Not yet implemented")
    }

    /**
     * Колбэк при завершении работы презентера
     */
    override fun onDestroy() {
        view = null
    }

    /**
     * Колбэк при создании элемента списка
//     * @param view Представление элемента списка счетчиков\
//     * @param position Индекс позиции, по которой будет отображен элемент
     */

//    fun onBindViewItem(view: IMeterListViewItem, position: Int) {
//        view.setName(meters[position].name)
//        view.setIndications(meters[position].serialNumber.toString())
//        // TODO: поставить имя счетчика
//    }

    fun onAddDevicesButtonClick(){
        view?.startSearchDevicesActivity()
    }

    /**
     * Колбэк при нажатии на кнопку "Архив показаний"
     */
    fun onArchiveButtonClick() {
        // TODO: передавать id выбранного токена в App.meterService.id
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

    fun onLogoutButtonClick(){
      view?.startLogRegActivity()
   }

    fun deleteToken(){
        App.userDataService.deleteToken()
    }

    /**
     * Кол-во элементов в списке
     */
//    val itemsCount
//      get() = meters.size


    private lateinit var meters: Array<Meter>
    private var view: IMainView? = null
//    private var meters:
    // TODO:

}

