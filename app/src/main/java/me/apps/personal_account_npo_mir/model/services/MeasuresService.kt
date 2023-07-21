package me.apps.personal_account_npo_mir.model.services

import kotlinx.coroutines.CoroutineScope
import me.apps.personal_account_npo_mir.model.abstractions.measures.ImeasureService
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.putMeasure.PutMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.putMeasure.PutMeasureServerRequest

val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"
class MeasuresService(private val scope: CoroutineScope):ImeasureService {
    override fun putMeasure(deviceId: Int,
                            token:String,
                            measure:Measure,
                            resultListener: IServerRequestResultListener<PutMeasureRequestResult>
    ){
        val request = PutMeasureServerRequest(urlForHostLoopbackInterface, deviceId, token, measure, scope)
        request.setServerRequestListener(resultListener)
        request.run()

    }
}