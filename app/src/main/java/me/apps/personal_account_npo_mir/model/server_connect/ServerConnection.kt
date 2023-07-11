package me.apps.personal_account_npo_mir.model.server_connect



import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

private const val ENDPOINT = "http://localhost:5000/api/"
class ServerConnection {

    fun signIn(username: String, password: String): String {
        val urlAddress: String = ENDPOINT + "SignIn" + "/" + username + "/" + password
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String
        try {
            httpURLConnection =
                URL(urlAddress).openConnection() as HttpURLConnection
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

    fun signOut(): Boolean {
        TODO("Not yet implemented")
    }



    var username: String
        get() = TODO("Not yet implemented")
        set(value) {}
    var token: String
        get() = TODO("Not yet implemented")
        set(value) {}

    fun getMeters(Token: String): String{
        val urlAddress = URL(ENDPOINT + "Devices/getdevices")
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String
        try {
            val httpURLConnection = urlAddress.openConnection() as HttpURLConnection
            httpURLConnection.setRequestProperty("X-User-Token", Token)
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

        } catch (e:IOException) {
            e.printStackTrace()
            return ""
        }
        finally {
            httpURLConnection?.disconnect()
            streamReader?.close()
        }
    }
    fun signUp(
        username: String,
        password: String
    ): String {
        val URLAddress: String = ENDPOINT+"SignUp" + "/"+username+"/"+password
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String
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
    fun getLastMeasures(DeviceID: Int, Token:String): String {
        val urlAdress: String = ENDPOINT + "Measures/getlastmeasures/" + DeviceID
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String
        try {
            httpURLConnection =
                URL(urlAdress).openConnection() as HttpURLConnection
            httpURLConnection.apply {
                connectTimeout = 10000
                doInput = true
                httpURLConnection.setRequestProperty("X-User-Token", Token)
            }
            val streamReader = InputStreamReader(httpURLConnection.inputStream)
            streamReader.use { text = it.readText() }
            return text
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return ""

        } catch (e:IOException) {
            e.printStackTrace()
            return ""
        }
        finally {
            httpURLConnection?.disconnect()
            streamReader?.close()
        }
    }
    fun getDiagnostics(DeviceID: Int,Token: String):String{
        val urlAdress: String = ENDPOINT + "Diagnostics/" + DeviceID
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String
        try {
            httpURLConnection =
                URL(urlAdress).openConnection() as HttpURLConnection
            httpURLConnection.apply {
                connectTimeout = 10000
                doInput = true
            }
            httpURLConnection.setRequestProperty("X-User-Token", Token)
            val streamReader = InputStreamReader(httpURLConnection.inputStream)
            streamReader.use { text = it.readText() }
            return text
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return ""

        } catch (e:IOException) {
            e.printStackTrace()
            return ""
        }
        finally {
            httpURLConnection?.disconnect()
            streamReader?.close()
        }
    }
    fun bindDevices(DeviceID:Int, Token:String): String{
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String
        val urlAddress = URL(ENDPOINT + "Devices/linktouser?deviceId=" + DeviceID)
        try {
            httpURLConnection =
                urlAddress.openConnection() as HttpURLConnection
            httpURLConnection.setRequestProperty("X-User-Token", Token)
            httpURLConnection.apply {
                connectTimeout = 10000
                doInput = true
                requestMethod = "POST"
            }
            streamReader = InputStreamReader(httpURLConnection.inputStream)

            streamReader.use { text = it.readText() }
            httpURLConnection.disconnect()
            return text
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return ""
        } catch (e:IOException) {
            e.printStackTrace()
            return ""
        }
        finally {
            httpURLConnection?.disconnect()
            streamReader?.close()
        }
    }
}
