package me.apps.personal_account_npo_mir.model.abstractions.meters

data class Meter (val id: String, val name: String, val serialNumber:String,
                  val contractNumber: String,val address:String){
    constructor() : this("", "", "", "", " ") {

    }
}