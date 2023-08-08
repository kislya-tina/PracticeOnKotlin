package me.apps.personal_account_npo_mir.model.abstractions.user_data

import android.content.Context

interface ITokenService {
    fun saveToken(token: String)
    fun deleteToken()
    var token: String
    var app: Context
}