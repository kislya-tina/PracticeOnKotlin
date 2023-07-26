package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IDateListViewItem
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IArchiveView

class ArchivePresenter : IPresenter<IArchiveView> {

    /**
     * Колбэк при создании View
     */
    override fun onViewCreated(view: IArchiveView) {
        this.view = view
        val username = App.userDataService.username
        view.setHeader(username)
//        dates = App.archiveDateService.dates
//        view.refreshItems()
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
        view?.startItemActivity(dates[position])
    }

    val itemsCount
        get() = dates.size

    private var dates: List<Long> = App.archiveDateService.dates
    private var view: IArchiveView? = null
    private var currentClickedPosition: Int = -1

}