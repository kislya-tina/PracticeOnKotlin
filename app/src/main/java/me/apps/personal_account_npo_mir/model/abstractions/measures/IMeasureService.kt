package me.apps.personal_account_npo_mir.model.abstractions.measures

import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_measures.GetMeasuresRequestResult
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
        token: String,
        resultListener: IServerRequestResultListener<GetLastMeasureRequestResult>
    )

    fun getMeasures(
        deviceId: Int,
        token: String,
        dateFrom: String,
        dateTo: String,
        pageNumber: Int,
        countInPage: Int,
        resultListener: IServerRequestResultListener<GetMeasuresRequestResult>
    )
    fun saveMeasure(
        measure: Measure
    )

    var measure : Measure?
    var measuresMap: MutableMap<Int, Measure>
    fun saveMeasuresMap(key: Int, measure: Measure)
}