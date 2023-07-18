package me.apps.personal_account_npo_mir.presentation.main

import android.view.View
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.meters.Meter
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IMainView
import me.apps.personal_account_npo_mir.view.abstractions.main.IMeterListViewItem

class InstrumentPresenter : IPresenter<IMainView> {

    override fun onViewCreated(view: IMainView) {
        this.view = view
        val username = App.userDataService.username
        //val username = "user"
        view.setHeader(username)
        meters = App.metersService.getMeters(username)
//        meterID = App.metersService.getMeterID()
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
        view.setName(meters[position].name)
        view.setIndications(meters[position].serialNumber.toString())
    }

    fun onStartArchiveActivity(){
        view?.startArchiveActivity()
    }

    fun onStartDiagnosticActivity(){
        view?.startDiagnosticActivity()
    }

    fun onStartTransmittalActivity(){
        view?.startTransmittalActivity()
    }

    fun onStartInformationActivity(){
        view?.startInformationActivity()
    }

    /**
     * Кол-во элементов в списке
     */
    val itemsCount
        get() = meters.size

    private lateinit var meters: List<Meter>
    private var view: IMainView? = null
    private var meterID: Int = 0

    //хранить здесь id устройства и передавать его для создания фрагмента
}
