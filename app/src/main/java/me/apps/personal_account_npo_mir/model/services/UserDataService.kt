package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService

class UserDataService() : IUserDataService {
    // TODO: добавить в конструктор
    /*
    val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
    var editor = sharedPreference.edit()
    editor.putString("token",token)
    editor.commit()

    sharedPreference.getString("token","userToken")
     */
    override var token: String
        get() = _token
        set(value) {
            _token = value
        }
    override var username: String
        get() = _username
        set(value) {
            _username = value
        }
    private var _token: String = ""
    private var _username: String = ""
}