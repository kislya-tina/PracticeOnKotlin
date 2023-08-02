package me.apps.personal_account_npo_mir.presentation.main.instruments

import com.google.gson.Gson
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.main.instruments.InstrumentFragment

class InstrumentFragmentPresenter : IPresenter<InstrumentFragment>,
    IServerRequestResultListener<GetLastMeasureRequestResult>{

    object listener1: IServerRequestResultListener<GetMetersRequestResult>{
        override fun onRequestSuccess(result: GetMetersRequestResult) {
            TODO("Not yet implemented")
        }

        override fun onRequestFail(message: ErrorCode) {
            TODO("Not yet implemented")
        }

    }

    override fun onViewCreated(view: InstrumentFragment) {
        this.view = view
        name = App.metersService.meters[0].name
    }

    override fun onDestroy() {
        view = null
    }

    override fun onRequestSuccess(result: GetMetersRequestResult) {
        TODO("Not yet implemented")
    }

    override fun onRequestSuccess(result: GetLastMeasureRequestResult) {
        try {
            var measure = Gson().fromJson(result.toString(), Measure::class.java)
            App.measuresService.saveMeasure(measure)
            view?.setMeterIndications()
            println(result)
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