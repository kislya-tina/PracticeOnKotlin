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
    IServerRequestResultListener<GetLastMeasureRequestResult> {

    override fun onViewCreated(view: InstrumentFragment) {
        this.view = view
    }

    override fun onDestroy() {
        view = null
    }

    override fun onRequestSuccess(result: GetLastMeasureRequestResult) {
        try {
            App.measuresService.measure = Gson().fromJson(result.toString(), Measure::class.java)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onRequestFail(message: ErrorCode) {

    }

    private var view : InstrumentFragment? = null
}