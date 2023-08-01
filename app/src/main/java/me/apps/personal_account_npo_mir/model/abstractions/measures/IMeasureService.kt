package me.apps.personal_account_npo_mir.model.abstractions.measures

import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.put_measure.PutMeasureRequestResult

interface IMeasureService {
    fun putMeasure(
        deviceId: Int,
        token: String,
        measure: Measure,
        resultListener: IServerRequestResultListener<PutMeasureRequestResult>
    )

    fun getLastMeasure(
        deviceId: Int,
        token:String,
        resultListener: IServerRequestResultListener<GetLastMeasureRequestResult>
    )

    var measure : Measure?
}