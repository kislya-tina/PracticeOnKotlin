package me.apps.personal_account_npo_mir.model.services

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.abstractions.meters.Meter
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.bind_meter.BindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.bind_meter.BindMeterServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.find_device.FindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.find_device.FindMeterServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersServerRequest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random
import kotlin.random.nextInt

class MetersService(private val scope: CoroutineScope) : IMetersService, IServerRequestResultListener<GetMetersRequestResult> {
    private val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"

    init{
       getMeters(App.userDataService.token, this)
    }
    override fun onRequestSuccess(result: GetMetersRequestResult) {
        val meters:Array<Meter> = Gson().fromJson(result.meters, Array<Meter>::class.java)
        this.meters = meters
    }

    override fun onRequestFail(message: ErrorCode) {
        TODO("Not yet implemented")
    }
    override fun getMeters(token:String, resultListener: IServerRequestResultListener<GetMetersRequestResult>){
        val request = GetMetersServerRequest(me.apps.personal_account_npo_mir.model.services.urlForHostLoopbackInterface, token, App.networkScope)
        request.setServerRequestListener(resultListener)
        request.run()
    }
    override fun saveMeters(
       meters: Array<Meter>
    ) {
        this.meters = meters
    }

    override fun findMeter(key: Int, limit: Int, token: String, resultListener:IServerRequestResultListener<FindMeterRequestResult>) {
        val request = FindMeterServerRequest(urlForHostLoopbackInterface, key, limit, token, scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }

    override fun bindMeter(
        deviceId: Int,
        token: String,
        resultListener: IServerRequestResultListener<BindMeterRequestResult>
    ) {
        val request = BindMeterServerRequest(urlForHostLoopbackInterface, deviceId, token, scope)
        request.setServerRequestListener(resultListener)
        request.run()

    }

    override var meters: Array<Meter>
        get() {
            return _meters
        }
        set(value) {
            _meters = value
        }
    override var id: Int
        get() = _id
        set(value) {
            _id = value
        }

    private var _id = 0
    private var _meters: Array<Meter> = arrayOf(Meter(), Meter(), Meter(), Meter())

}