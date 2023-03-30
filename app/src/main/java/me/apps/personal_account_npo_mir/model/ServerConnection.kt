package me.apps.personal_account_npo_mir.model



import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

private const val ENDPOINT = "http://localhost:5000/api/"
class ServerConnection {
    fun signIn(username: String,password: String):String{
        return "{\"SessionId\":784,\"Username\":\"user\"}.0554B274A9AE2954F97400A4588A0A2B"
    }
    fun signIn_real(username: String, password: String): String {
        val urlAdress: String = ENDPOINT + "SignIn" + "/" + username + "/" + password
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String = ""
        try {
            httpURLConnection =
                URL(urlAdress).openConnection() as HttpURLConnection
            httpURLConnection.apply {
                connectTimeout = 10000
                doInput = true
            }
            val streamReader = InputStreamReader(httpURLConnection.inputStream)
            streamReader.use { text = it.readText() }
            return text
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return ""

        } catch (e: IOException) {
            e.printStackTrace()
            return ""
        }
        finally {
            httpURLConnection?.disconnect()
            streamReader?.close()
        }
    }
    fun getMeters(Token: String): String{
        val httpURLConnection = URL(ENDPOINT + "Devices/getdevices").openConnection() as HttpURLConnection
        httpURLConnection.setRequestProperty("X-User-Token",Token)
        httpURLConnection.apply {
            connectTimeout = 10000
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
}
