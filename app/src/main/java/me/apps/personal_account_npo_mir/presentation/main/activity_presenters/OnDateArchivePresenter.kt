package me.apps.personal_account_npo_mir.presentation.main.activity_presenters

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IOnDateArchiveView

class OnDateArchivePresenter : IPresenter<IOnDateArchiveView> {
    override fun onViewCreated(view: IOnDateArchiveView) {
        var currentMeter = App.metersService.meters[App.indexService.index]
        this.view = view
        val date = App.archiveDateService.dates[view.getPosition()]
        val measure = App.archiveDateService.arrayOfMeasures[view.getPosition()]
        view.setHeader(date)
        view.setMeasure(measure)
        //view.setMeasure(App.archiveDateService.arrayOfMeasures[currentMeter])
    }

    override fun onDestroy() {
        this.view = null
    }

    // TODO: Сделать так, чтобы во вью подавался объект Measure,
    //  в котором лежат показания полученные из getLastMeasures()


    var currentClickedDate: Int = App.archiveDateService.currentClickedDate
    private var view: IOnDateArchiveView? = null

}