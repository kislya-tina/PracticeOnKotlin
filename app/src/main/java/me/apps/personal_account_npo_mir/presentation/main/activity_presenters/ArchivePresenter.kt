package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IDateListViewItem
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IArchiveView

class ArchivePresenter : IPresenter<IArchiveView> {
    override fun onViewCreated(view: IArchiveView) {
        this.view = view
        val username = App.loginService.username
        view.setHeader(username)
        dates = App.archiveDateService.dates
    }

    override fun onDestroy() {
        view = null
    }

    fun onBindViewItem(view: IDateListViewItem, position: Int){
        view.setDate(dates[position])
    }

    fun onItemClick(position : Int){
        currentClickedPosition = position
        view?.startItemActivity()
    }

    val itemsCount
        get() = 10

    private lateinit var dates: List<Long>
    private var view: IArchiveView? = null
    private var currentClickedPosition: Int = -1

}