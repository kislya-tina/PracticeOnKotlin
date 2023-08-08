package me.apps.personal_account_npo_mir.model.server_connect.abstractions

import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode

interface IServerRequestResultListener<TResult> {
    fun onRequestSuccess(result: TResult)
    fun onRequestFail(message: ErrorCode)
}