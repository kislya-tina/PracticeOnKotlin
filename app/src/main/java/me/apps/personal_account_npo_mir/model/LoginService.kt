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
    fun logIn(USERNAME:String, PASSWORD:String): String {
        val httpURLConnection = URL(ENDPOINT+ "SignIn" + "/"+USERNAME+"/"+PASSWORD).openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = 10000
            requestMethod = "GET"
            doInput = true
        }
        if(httpURLConnection.responseCode!= HttpURLConnection.HTTP_OK) {
            return "error"
        }
        val streamReader = InputStreamReader(httpURLConnection.inputStream)
        var text: String = ""
        streamReader.use{text = it.readText()}
        httpURLConnection.disconnect()
        return text

    }
    fun regUp(USERNAME:String, PASSWORD:String): String {

        val ENDPOINT = "http://localhost:5000/api/"
        val httpURLConnection = URL(ENDPOINT+"SignUp" + "/"+USERNAME+"/"+PASSWORD).openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = 10000
            requestMethod = "GET"
            doInput = true
        }

        if(httpURLConnection.responseCode!= HttpURLConnection.HTTP_OK) {
            return "erorro"
        }
        val streamReader = InputStreamReader(httpURLConnection.inputStream)
        var text: String = ""
        streamReader.use{text = it.readText()}
        httpURLConnection.disconnect()
        return text
    }

    override fun signIn(username: String, password: String): Boolean {
        return true
    }

    override fun signOut() {
        TODO("Not yet implemented")
    }

    override fun signUp(username: String, password: String, email: String, phoneNumber: String) {
        token = "17"
    }

    override var username: String
        get() = "OPa"
        set(value) {}
    override var token: String
        get() = "pop"
        set(value) {}


}