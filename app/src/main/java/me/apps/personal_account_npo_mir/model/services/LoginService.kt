package me.apps.personal_account_npo_mir.model.services

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.server_connect.ServerConnection


class LoginService() : ILoginService {
    override var username: String
        get() = username
        set(value) {
            username = value
        }


    override fun signIn(username: String, password: String): Boolean {
        val token:String = ServerConnection().signIn(username,password)
        App.userDataService.token = token
        return token.isNotBlank()
    }

    override fun signOut(): Boolean {
        return true
    }

    override fun signUp(username: String, password: String, email: String, phoneNumber: String): Boolean {
        val token:String = ServerConnection().signUp(username,password)
        App.userDataService.token = token
        return token.isNotEmpty()
    }

}