package me.apps.personal_account_npo_mir.model.abstractions.meters

data class Meter(
    // TODO: id must be int
    val id: Int, val name: String, val serialNumber: Long,
    val contractNumber: Long, val address: String
) {
    constructor() : this(0, "", 0, 0, " ") {

    }

    constructor(meter: Meter) : this(
        meter.id, meter.name, meter.serialNumber,
        meter.contractNumber, meter.address
    )
}