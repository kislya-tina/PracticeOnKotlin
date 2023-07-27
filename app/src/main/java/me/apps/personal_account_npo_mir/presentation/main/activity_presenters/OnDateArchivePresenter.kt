package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IOnDateArchiveView

class OnDateArchivePresenter : IPresenter<IOnDateArchiveView> {
    override fun onViewCreated(view: IOnDateArchiveView) {
        this.view = view
        val date : Long = App.archiveDateService.dates[view.getPosition()]
        view.setHeader(date.toString())
//        view.setMeasure(Measure(App.measuresService.getLastMeasure()))
        // TODO: Сделать так, чтобы во вью подавался объект Measure,
        //  в котором лежат показания полученные из getLastMeasures()
    }

    override fun onDestroy() {
        this.view = null
    }

    private var view : IOnDateArchiveView? = null
}