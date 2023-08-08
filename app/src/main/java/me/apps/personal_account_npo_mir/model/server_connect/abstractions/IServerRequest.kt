package me.apps.personal_account_npo_mir.model.server_connect.abstractions

interface IServerRequest<TResult> {
    fun setServerRequestListener(listener: IServerRequestResultListener<TResult>)
    fun run()
}