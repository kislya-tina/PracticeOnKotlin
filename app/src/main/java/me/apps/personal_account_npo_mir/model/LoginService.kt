package me.apps.personal_account_npo_mir.model

import android.content.Context
import android.widget.Toast
import me.apps.personal_account_npo_mir.model.abstractions.ILoginService
import me.apps.personal_account_npo_mir.view.login.LogRegActivity
import me.apps.personal_account_npo_mir.view.login.RegistrationFragment
import me.apps.personal_account_npo_mir.view.main.InstrumentActivity
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

private const val ENDPOINT = "http://localhost:5000/api/"

class LoginService : ILoginService{


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

    override var username: String
        get() = "OPa"
        set(value) {}
    override var token: String
        get() = "pop"
        set(value) {}


}