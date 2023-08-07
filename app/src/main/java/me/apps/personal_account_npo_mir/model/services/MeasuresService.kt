package me.apps.personal_account_npo_mir.model.services

import kotlinx.coroutines.CoroutineScope
import me.apps.personal_account_npo_mir.model.abstractions.measures.IMeasureService
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.get_measures.GetMeasuresRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_measures.GetMeasuresServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.put_measure.PutMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.put_measure.PutMeasureServerRequest

const val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"
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
    override fun getMeasures(deviceId: Int,
                             token:String,
                             dateFrom:String,
                             dateTo:String,
                             pageNumber:Int,
                             countInPage: Int,
                             resultListener: IServerRequestResultListener<GetMeasuresRequestResult>){
        val request = GetMeasuresServerRequest(urlForHostLoopbackInterface,deviceId,token,dateFrom,dateTo,pageNumber,countInPage,scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }
    override fun saveMeasure(measure: Measure){
        this.measure = measure
    }
    override fun saveMeasures(measure: Measure){
        measures+=measure
    }
    override fun saveMeasuresMap(key:Int, measure: Measure){

    }

    override var measure : Measure? = null
    override var measures: Array<Measure>
        get() {
            return _measures
        }
        set(value) {_measures = value}
    override var measuresMap: MutableMap<Int, Measure> = mutableMapOf()
    private var _measures: Array<Measure> = arrayOf(Measure("", "", "", "", "", ""))
}
