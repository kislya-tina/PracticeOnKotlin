package me.apps.personal_account_npo_mir.model.abstractions.meters

import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.bind_meter.BindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.find_device.FindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult

interface IMetersService {
    /**
     * Получить счетчики пользователя
     * @param username Имя пользователя
     */
    //пока не добавил лист метеров
    fun getMeters(token: String, resultListener: IServerRequestResultListener<GetMetersRequestResult>)
    fun bindMeter(deviceId:Int, token:String,resultListener: IServerRequestResultListener<BindMeterRequestResult>)
    //заглушка
    fun getLastMeasures(deviceID: Int, token:String): Map<String, Any>
    fun findMeter(key: Int, limit:Int, token:String, resultListener: IServerRequestResultListener<FindMeterRequestResult>)
}