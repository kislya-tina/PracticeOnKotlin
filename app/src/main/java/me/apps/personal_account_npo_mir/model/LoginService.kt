package me.apps.personal_account_npo_mir.model

import me.apps.personal_account_npo_mir.model.abstractions.ILoginService

private const val ENDPOINT = "http://localhost:5000/api/"

class LoginService() : ILoginService{


    override fun signIn(username: String, password: String): Boolean {
        val token:String = serverConnect.signIn(username,password)
        return token != "Unauthorized"
    }

    override fun signOut(): Boolean {
        return true
    }

    override fun signUp(username: String, password: String, email: String, phoneNumber: String): Boolean {
        val token:String = serverConnect.signUp(username,password)
        return token!="Authorized"
    }
    private val serverConnect : IServerConnection
        get() {
            TODO()
        }
    override var username: String
        get() = "OPa"
        set(value) {}
    override var token: String
        get() = "pop"
        set(value) {}



}