package me.apps.personal_account_npo_mir.model.abstractions.measures

import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.putMeasure.PutMeasureRequestResult

interface ImeasureService {
    fun putMeasure(
        deviceId: Int,
        token: String,
        measure: Measure,
        resultListener: IServerRequestResultListener<PutMeasureRequestResult>
    )
}