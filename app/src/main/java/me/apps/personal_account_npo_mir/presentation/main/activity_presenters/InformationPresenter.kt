package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IInformationView

class InformationPresenter: IPresenter<IInformationView> {
    override fun onViewCreated(view: IInformationView) {
        this.view = view
    }

    override fun onDestroy() {
        view = null
    }

    fun getMeterName(): String{
        return meter.name
    }

    fun getSerialNumber(): String{
        return meter.serialNumber
    }

    fun getAddress(): String{
        return meter.address
    }

    private var view: IInformationView? = null
    private var meter = App.metersService.meters[App.indexService.index]
}