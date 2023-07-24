package me.apps.personal_account_npo_mir.model.abstractions.meters

import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.bindMeter.BindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.getMeters.GetMetersRequestResult

interface IMetersService {
    /**
     * Получить счетчики пользователя
     * @param username Имя пользователя
     */
    //пока не добавил лист метеров
    fun getMeters(token: String, resultListener: IServerRequestResultListener<GetMetersRequestResult>)
    fun bindMeter(deviceId:Int, token:String,resultListener: IServerRequestResultListener<BindMeterRequestResult>)
    //заглушка
    fun getLastMeasures(DeviceID: Int, Token:String): Map<String, Any>

    //fun getMeters(username: String)
}