package me.apps.personal_account_npo_mir.model.server_connect



import com.google.gson.Gson
import kotlinx.coroutines.*
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import okhttp3.*
import okio.use
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

private const val ENDPOINT = "http://localhost:5000/api/"
class ServerConnection {
    fun PutMeasure(deviceID: Int, token:String,
                   measure: Measure
    ) {
        val urlAddress: String = ENDPOINT + "Measures/PutMeasure?deviceId=" + deviceID
        var httpURLConnection: HttpURLConnection? = null
        var writer: OutputStreamWriter? = null
        val gson = Gson()
        try {

            val url = URL(urlAddress)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("X-User-Token", token)
            connection.doOutput = true
            val measureJson = gson.toJson(measure)
            println(measureJson)
            val outputStream = OutputStreamWriter(connection.outputStream)
            outputStream.write(measureJson)
            outputStream.flush()
            outputStream.close()

            val responseCode = connection.responseCode
            println("Response Code : $responseCode")
        } catch (e: MalformedURLException) {
            e.printStackTrace()


        } catch (e:IOException) {
            e.printStackTrace()

        }
        finally {
            httpURLConnection?.disconnect()
            writer?.close()
        }
    }
    suspend fun signIn2(username:String, password: String): String? {
        val client = OkHttpClient()
        val url: String = ENDPOINT + "SignIn" + "/" + username + "/" + password
        val request = Request.Builder()
            .url(url)
            .build()
        var responseString:String?=null


            val call = client.newCall(request)
            withContext(Dispatchers.IO) {
                try {
                    val response = call.execute()
                    val responseBody = response.body?.string()
                    responseString = responseBody
                } catch (e: IOException) {
                    // Обработка ошибки
                }
            }

            return responseString
    }

    fun signIn(username: String, password: String):String{

            val urlAddress: String = ENDPOINT + "SignIn" + "/" + username + "/" + password
            var httpURLConnection: HttpURLConnection? = null
            var streamReader: InputStreamReader? = null
            var text: String = ""
            try {
                httpURLConnection =
                    URL(urlAddress).openConnection() as HttpURLConnection
                httpURLConnection.apply {
                    connectTimeout = 10000
                    doInput = true
                }

                    val streamReader = InputStreamReader(httpURLConnection.inputStream)
                    streamReader.use { text = it.readText()
                    return text
                }
                return text
            } catch (e: MalformedURLException) {
                e.printStackTrace()
                return ""

            } catch (e: IOException) {
                e.printStackTrace()
                return ""
            } finally {
                httpURLConnection?.disconnect()
                streamReader?.close()
            }
        }


    fun signOut(): Boolean {
        TODO("Not yet implemented")
    }
    fun getMeters(Token: String): String{
        val urlAddress = URL(ENDPOINT + "Devices/getdevices")
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String = ""
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
    fun getLastMeasures(DeviceID: Int, Token:String): String {
        val urlAdress: String = ENDPOINT + "Measures/getlastmeasures/" + DeviceID
        var httpURLConnection: HttpURLConnection? = null
        var streamReader: InputStreamReader? = null
        var text: String = ""
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
        var text: String = ""
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
        var text: String = ""
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
