package me.apps.personal_account_npo_mir.model.services
import kotlinx.coroutines.CoroutineScope
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.bind_meter.BindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.bind_meter.BindMeterServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.find_device.FindMeterRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.find_device.FindMeterServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersServerRequest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random
import kotlin.random.nextInt

class MetersService(private val scope: CoroutineScope) : IMetersService {
    private val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"


    override fun getLastMeasures(deviceID: Int, token: String): Map<String, Any> {
        val tariff1: Int = generateId()
        val tariff2: Int = generateId()
        val tariff3: Int = generateId()
        val tariff4: Int = generateId()
        val summary: Int = tariff1 + tariff2 + tariff3 + tariff4
        val measure = mapOf(
            "summary" to summary, "tariff1" to tariff1, "tariff2" to tariff2,
            "tariff3" to tariff3, "tariff4" to  tariff4, "timestamp" to LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
            )
        )
        return measure
    }

    /*override fun getMeters(username: String): List<Meter> = listOf(
        Meter(
            generateId(),
            generateMeterName(),
            generateSerialContractNumber(),
            generateSerialContractNumber(),
            "1 Островская 5"
        ),
        Meter(
            generateId(),
            generateMeterName(),
            generateSerialContractNumber(),
            generateSerialContractNumber(),
            "Бульвар Архитекторов 1г"
        ),
        Meter(
            generateId(),
            generateMeterName(),
            generateSerialContractNumber(),
            generateSerialContractNumber(),
            "Проспект Мира 55а"
        ),
        Meter(
            generateId(),
            generateMeterName(),
            generateSerialContractNumber(),
            generateSerialContractNumber(),
            "Дмитриева 13"
        ),
        Meter(
            generateId(),
            generateMeterName(),
            generateSerialContractNumber(),
            generateSerialContractNumber(),
            "Герцена 49/1"
        ),
        Meter(
            generateId(),
            generateMeterName(),
            generateSerialContractNumber(),
            generateSerialContractNumber(),
            "Малиновского 13"
        ),
    )*/

    override fun getMeters(
        token: String,
        resultListener: IServerRequestResultListener<GetMetersRequestResult>
    ) {
        val request = GetMetersServerRequest(urlForHostLoopbackInterface, token, scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }

    override fun findMeter(key: Int, limit: Int, token: String, resultListener:IServerRequestResultListener<FindMeterRequestResult>) {
        val request = FindMeterServerRequest(urlForHostLoopbackInterface, key, limit, token, scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }

    override fun bindMeter(
        deviceId: Int,
        token: String,
        resultListener: IServerRequestResultListener<BindMeterRequestResult>
    ) {
        val request = BindMeterServerRequest(urlForHostLoopbackInterface, deviceId, token, scope)
        request.setServerRequestListener(resultListener)
        request.run()

    }





        fun generateMeterName(): String {
            return "C05-" + (1..10).map { Random.nextInt(1..9) }.joinToString("")
        }

        fun generateId(): Int =
            Random.nextInt(0, 255)

        fun generateSerialContractNumber(): Long {
            return (1..10).map { Random.nextInt(1..9) }.joinToString("").toLong()
        }
}