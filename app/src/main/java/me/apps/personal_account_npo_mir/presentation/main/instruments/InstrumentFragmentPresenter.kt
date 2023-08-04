package me.apps.personal_account_npo_mir.presentation.main.instruments

import com.google.gson.Gson
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.main.instruments.InstrumentFragment

class InstrumentFragmentPresenter : IPresenter<InstrumentFragment>{

    override fun onViewCreated(view: InstrumentFragment) {
        this.view = view
    }

    override fun onDestroy() {
        view = null
    }


    fun onMeterIndexCreate(meterIndex : Int){
        this.meterIndex = meterIndex
        this.view?.setMeterIndications(App.measuresService.measures[meterIndex].summary)
        this.view?.setMeterTime(App.measuresService.measures[meterIndex].timestamp)
        //meterID = App.metersService.meters[meterIndex].id.toInt()
        name = App.metersService.meters[meterID].name
        view?.setMeterName(name)
    }

    private var view: InstrumentFragment? = null
    var name : String = ""
    var meterID = 0
    var meterIndex = 0
}