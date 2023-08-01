package me.apps.personal_account_npo_mir.model.abstractions.measures

data class Measure(val summary:Double, val tariff1:Double, val tariff2:Double,
                   val tariff3:Double, val tariff4:Double, var timestamp:String) {
}