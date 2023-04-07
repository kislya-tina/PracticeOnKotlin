package me.apps.personal_account_npo_mir.model.ServerConnect



import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

private const val ENDPOINT = "http://localhost:5000/api/"
class ServerConnection : IServerConnection {

    override fun signIn(username: String, password: String): String {
        val URLAddress: String = ENDPOINT + "SignIn" + "/" + username + "/" + password
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String = ""
        try {
            httpURLConnection =
                URL(URLAddress).openConnection() as HttpURLConnection
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
        //if(httpURLConnection.responseCode!= HttpURLConnection.HTTP_OK) {
          //  return "error"
        //}
        val streamReader = InputStreamReader(httpURLConnection.inputStream)
        var text: String = ""
        streamReader.use{text = it.readText()}
        httpURLConnection.disconnect()
        return text
    }
    override fun signUp(username:String, password: String): String {
        val httpURLConnection = URL(ENDPOINT+"SignUp" + "/"+username+"/"+password).openConnection() as HttpURLConnection
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
}
