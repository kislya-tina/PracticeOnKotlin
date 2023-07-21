package me.apps.personal_account_npo_mir.model.services

import kotlinx.coroutines.CoroutineScope
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.abstractions.meters.Meter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random
import kotlin.random.nextInt

class MetersService(private val scope: CoroutineScope) : IMetersService {
    val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"
    // val token: String = App.userDataService.token
    override fun getLastMeasures(DeviceID: Int, Token:String): Map<String, Any> {
        val tariff1:Int = generateId()
        val tariff2:Int = generateId()
        val tariff3:Int = generateId()
        val tariff4:Int = generateId()
        val summary:Int = tariff1+tariff2+tariff3+tariff4
        val measure = mapOf("summary" to summary, "tariff1" to tariff1,"tariff2" to tariff2,
            "tariff3" to tariff3, "tariff4" to tariff4, "timestamp" to LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")))
        return measure
    }
    override fun getMeters(username: String): List<Meter> = listOf(
        Meter(generateId(), generateMeterName(), generateSerialContractNumber(), generateSerialContractNumber(),"1 Островская 5"),
        Meter(generateId(), generateMeterName(), generateSerialContractNumber(), generateSerialContractNumber(),"Бульвар Архитекторов 1г"),
        Meter(generateId(), generateMeterName(), generateSerialContractNumber(), generateSerialContractNumber(),"Проспект Мира 55а"),
        Meter(generateId(), generateMeterName(), generateSerialContractNumber(), generateSerialContractNumber(),"Дмитриева 13"),
        Meter(generateId(), generateMeterName(), generateSerialContractNumber(), generateSerialContractNumber(),"Герцена 49/1"),
        Meter(generateId(), generateMeterName(), generateSerialContractNumber(), generateSerialContractNumber(),"Малиновского 13"),
    )
    //не возвращает лист метеров, возвращает стринг
    /*override fun getMeters(
                           resultListener: IServerRequestResultListener<GetMetersRequestResult>
    ):List<Meter>{
        val request = GetMetersServerRequest(urlForHostLoopbackInterface, token, scope)
        request.setServerRequestListener(resultListener)
        request.run()

    }*/




    private fun generateMeterName(): String {
        return "C05-" + (1..10).map { Random.nextInt(1..9) }.joinToString("")
    }
    private fun generateId(): Int =
        Random.nextInt(0, 255)
    private fun generateSerialContractNumber(): Long {
        return (1..10).map { Random.nextInt(1..9) }.joinToString("").toLong()
    }
}