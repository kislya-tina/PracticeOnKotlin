package me.apps.personal_account_npo_mir.model.abstractions.user_data

interface IUserDataService {
    var token: String
    var username: String

    fun deleteToken()
}