package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import com.google.gson.Gson
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IDateListViewItem
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_measures.GetMeasuresRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IArchiveView

class ArchivePresenter : IPresenter<IArchiveView>, IServerRequestResultListener<GetMeasuresRequestResult> {

    /**
     * Колбэк при создании View
     */
    override fun onViewCreated(view: IArchiveView) {
        this.view = view
        dates = App.archiveDateService.dates
        view.refreshItems()
    }

    /**
     * Колбэк при завершении работы презентера
     */
    override fun onDestroy() {
        view = null
    }

    /**
     * Колбэк при создании элемента списка
     */
    fun onBindViewItem(view: IDateListViewItem, position: Int){
        view.setDate(dates[position])
    }

    /**
     * Колбэк при нажатии на элемент списка
     */
    fun onItemClick(position : Int){
        currentClickedPosition = position
        App.archiveDateService.currentClickedDate = position
        dates[position]
        view?.startItemActivity()
    }

    fun onTransferButtonClick(fromDate: String, toDate: String){
        var currentMeter = App.metersService.meters[App.indexService.index]
        App.measuresService.getMeasures(currentMeter.id, App.userDataService.token,
            "$fromDate 00:00", "$toDate 00:00", 0, 100, this)
    }

    private var dates: List<String> = App.archiveDateService.dates
    private var view: IArchiveView? = null
    private var currentClickedPosition: Int = -1

    val itemsCount
        get() = dates.size

    override fun onRequestSuccess(result: GetMeasuresRequestResult) {
        App.archiveDateService.arrayOfMeasures = Gson().fromJson(result.measures, Array<Measure>::class.java)
        var list = mutableListOf<String>()
        for(measure in App.archiveDateService.arrayOfMeasures){
            list.add(measure.timestamp)
        }
        dates = list
        App.archiveDateService.dates = dates
        view?.refreshItems()
    }

    override fun onRequestFail(message: ErrorCode) {
        println(message.description)
    }
}