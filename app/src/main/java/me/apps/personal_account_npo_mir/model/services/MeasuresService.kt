package me.apps.personal_account_npo_mir.model.services

import kotlinx.coroutines.CoroutineScope
import me.apps.personal_account_npo_mir.model.abstractions.measures.IMeasureService
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.put_measure.PutMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.put_measure.PutMeasureServerRequest

val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"
class MeasuresService(private val scope: CoroutineScope):IMeasureService {
    override fun putMeasure(deviceId: Int,
                            token:String,
                            measure:Measure,
                            resultListener: IServerRequestResultListener<PutMeasureRequestResult>
    ){
        val request = PutMeasureServerRequest(urlForHostLoopbackInterface, deviceId, token, measure, scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }
    override fun getLastMeasure(deviceId:Int,
                                token:String,
                                resultListener: IServerRequestResultListener<GetLastMeasureRequestResult>){
        val request = GetLastMeasureServerRequest(urlForHostLoopbackInterface,deviceId,token,scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }

    override var measure : Measure? = null
}
