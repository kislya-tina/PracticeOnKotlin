package me.apps.personalaccountnpomir

import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

private const val ENDPOINT = "http://localhost:5000/api/"

class Back {

    fun logIn(USERNAME:String, PASSWORD:String): String {
        val httpURLConnection = URL(ENDPOINT+ "SignIn" + "/"+USERNAME+"/"+PASSWORD).openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = 10000
            requestMethod = "GET"
            doInput = true
        }
        if(httpURLConnection.responseCode!=HttpURLConnection.HTTP_OK) {
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

        if(httpURLConnection.responseCode!=HttpURLConnection.HTTP_OK) {
            return "erorro"
        }
        val streamReader = InputStreamReader(httpURLConnection.inputStream)
        var text: String = ""
        streamReader.use{text = it.readText()}
        httpURLConnection.disconnect()
        return text
    }
}