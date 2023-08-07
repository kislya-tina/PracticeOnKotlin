package me.apps.personal_account_npo_mir.model.server_connect.get_last_measure

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.services.urlForHostLoopbackInterface
import okio.use
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class GetLastMeasureServerRequest(private val url:String,
                                  private val deviceId:Int,
                                  private val token:String,
                                  private val scope: CoroutineScope): IServerRequest<GetLastMeasureRequestResult> {
    override fun setServerRequestListener(listener: IServerRequestResultListener<GetLastMeasureRequestResult>) {
        this.listener = listener
    }

    override fun run() {
        scope.launch {


            if (url == "") {
                withContext(Dispatchers.Main) {
                    listener?.onRequestFail(ErrorCode.BLANK_URL)
                }
            } else if (deviceId == null) {
                withContext(Dispatchers.Main) {
                    listener?.onRequestFail(ErrorCode.BLANK_USERNAME)
                }
            } else if (token == "") {
                withContext(Dispatchers.Main) {
                    listener?.onRequestFail(ErrorCode.BLANK_PASSWORD)
                }
            } else {
                val urlAdress: String =
                    urlForHostLoopbackInterface + "Measures/getlastmeasures/" + deviceId
                var httpURLConnection: HttpURLConnection? = null
                var streamReader: InputStreamReader? = null
                var measure: String = ""
                try {
                    httpURLConnection =
                        URL(urlAdress).openConnection() as HttpURLConnection
                    httpURLConnection.apply {
                        connectTimeout = 10000
                        doInput = true
                    }
                    httpURLConnection.setRequestProperty("X-User-Token", token)
                    streamReader = InputStreamReader(httpURLConnection.inputStream)
                    streamReader.use {
                        measure = it.readText() }
                    withContext(Dispatchers.Main) {
                        listener?.onRequestSuccess(GetLastMeasureRequestResult(measure, deviceId))
                    }
                } catch (e: MalformedURLException) {
                    withContext(Dispatchers.Main) {
                        listener?.onRequestFail(ErrorCode.BLANK_URL)
                    }
                } catch (e: IOException) {
                    withContext(Dispatchers.Main) {
                        listener?.onRequestFail(ErrorCode.BLANK_URL)
                    }
                } finally {
                    httpURLConnection?.disconnect()
                    streamReader?.close()
                }
            }

            listener = null
        }
    }

    private var listener: IServerRequestResultListener<GetLastMeasureRequestResult>? = null
}

