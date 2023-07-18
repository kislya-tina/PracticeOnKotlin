package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService

class UserDataService() : IUserDataService {
    override var token:String
        get() = _token
        set(value) {_token = value}
    override var username:String
        get() = _username
        set(value) {_username=value}
    var _token: String = ""
    var _username:String = ""
}