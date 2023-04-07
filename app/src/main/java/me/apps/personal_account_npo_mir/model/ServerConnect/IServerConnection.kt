package me.apps.personal_account_npo_mir.model.ServerConnect

import me.apps.personal_account_npo_mir.model.abstractions.meters.Meter

interface IServerConnection {
    fun signIn(username: String, password: String): String
    fun signUp(username: String, password: String): String
    //fun getMeters(username: String):List<Meter>

}