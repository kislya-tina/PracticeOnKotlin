package me.apps.personal_account_npo_mir.model.abstractions.meters

import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.getmeters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.signin.SignInRequestResult
import me.apps.personal_account_npo_mir.model.services.UserDataService

interface IMetersService {
    /**
     * Получить счетчики пользователя
     * @param username Имя пользователя
     */
    fun getMeters(username: String) : List<Meter>
    //кислый пока не добавил лист метеров
    //fun getMeters(resultListener: IServerRequestResultListener<GetMetersRequestResult>):List<Meter>
    fun getLastMeasures(DeviceID: Int, Token:String): Map<String, Any>

}