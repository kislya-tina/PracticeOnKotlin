package me.apps.personal_account_npo_mir.model

import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.server_connect.ServerConnection


class LoginService() : ILoginService {
    override var username: String
        get() = "OPa"
        set(value) {}


    override fun signIn(username: String, password: String): Boolean {
        val token:String = ServerConnection().signIn(username,password)
        return token != "Unauthorized"
    }

    override fun signOut(): Boolean {
        return true
    }

    override fun signUp(username: String, password: String, email: String, phoneNumber: String): Boolean {
        val token:String = ServerConnection().signUp(username,password)
        return token!="Authorized"
    }

}