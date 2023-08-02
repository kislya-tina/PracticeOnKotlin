package me.apps.personal_account_npo_mir.model.server_connect.put_measure

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import java.io.IOException
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.time.LocalDateTime

class PutMeasureServerRequest(
    private val urlForHostLoopbackInterface: String,
    private val deviceId: Int,
    val token: String,
    val measure: Measure,
    private val scope:CoroutineScope
):IServerRequest<PutMeasureRequestResult> {
    override fun setServerRequestListener(listener: IServerRequestResultListener<PutMeasureRequestResult>) {
        this.listener = listener
    }

    override fun run() {
        scope.launch {
            if (urlForHostLoopbackInterface == "") {
                withContext(Dispatchers.Main) {
                    listener?.onRequestFail(ErrorCode.BLANK_URL)
                }
            } else if (token == "") {
                withContext(Dispatchers.Main) {
                    listener?.onRequestFail(ErrorCode.BLANK_PASSWORD)
                }
            } else {
                val urlAddress: String =
                    urlForHostLoopbackInterface + "Measures/PutMeasure?deviceId=" + deviceId
                val httpURLConnection: HttpURLConnection? = null
                val writer: OutputStreamWriter? = null
                val gson = Gson()
                try {
                    val url = URL(urlAddress)
                    val connection =
                        withContext(Dispatchers.IO) {
                            url.openConnection()
                        } as HttpURLConnection
                    connection.requestMethod = "POST"
                    connection.setRequestProperty("Content-Type", "application/json")
                    connection.setRequestProperty("X-User-Token", token)
                    connection.doOutput = true
                    val datetime = LocalDateTime.now()
                    measure.timestamp = datetime.toString()
                    val measureJson = gson.toJson(measure)
                    println(measureJson)
                    val outputStream = OutputStreamWriter(connection.outputStream)
                    withContext(Dispatchers.IO) {
                        outputStream.write(measureJson)
                        outputStream.flush()
                        outputStream.close()
                    }
                    val responseCode = connection.responseCode
                    withContext(Dispatchers.Main){
                        listener?.onRequestSuccess(PutMeasureRequestResult(responseCode))
                    }

                } catch (e: MalformedURLException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()

                } finally {
                    httpURLConnection?.disconnect()
                    writer?.close()
                }

                listener = null
            }
        }
    }
    private var listener: IServerRequestResultListener<PutMeasureRequestResult>? = null
}
