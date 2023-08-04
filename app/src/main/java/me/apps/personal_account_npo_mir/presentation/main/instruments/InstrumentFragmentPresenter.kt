package me.apps.personal_account_npo_mir.presentation.main.instruments

import com.google.gson.Gson
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.main.instruments.InstrumentFragment

class InstrumentFragmentPresenter : IPresenter<InstrumentFragment>,
    IServerRequestResultListener<GetLastMeasureRequestResult>{

    override fun onViewCreated(view: InstrumentFragment) {
        this.view = view
        name = App.metersService.meters[view.meterID].name
    }

    override fun onDestroy() {
        view = null
    }

    override fun onRequestSuccess(result: GetLastMeasureRequestResult) {
        try {
            println(result.toString())
            val measure: Measure = Gson().fromJson(result.measure, Measure::class.java)
            App.measuresService.saveMeasure(measure)
            view?.setMeterIndications()
            view?.setMeterTime()
            view?.setMeterName()
            //вот тут надо назначать время счетчику
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestFail(message: ErrorCode) {
        println("pipipupu")
    }

    private var view: InstrumentFragment? = null
    var name : String = ""
}