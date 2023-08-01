package me.apps.personal_account_npo_mir.model.abstractions.measures

data class Measure(val summary:String, val tariff1:String, val tariff2:String,
                   val tariff3:String, val tariff4:String, var timestamp:String) {
}