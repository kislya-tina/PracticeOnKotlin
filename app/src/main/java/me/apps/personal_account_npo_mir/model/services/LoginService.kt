package me.apps.personal_account_npo_mir.model.services

import kotlinx.coroutines.*
import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.login.LogInServerRequest
import me.apps.personal_account_npo_mir.model.server_connect.signin.SignInRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.signin.SignInServerRequest


class SignInService(private val scope: CoroutineScope) : ILoginService {


val urlForHostLoopbackInterface: String = "http://10.0.2.2:5000/api/"
    override fun signIn(
        username: String,
        password: String,
        resultListener: IServerRequestResultListener<SignInRequestResult>
    ) {

        val request = SignInServerRequest(urlForHostLoopbackInterface, username,password, scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }

    override fun signOut(): Boolean {
        return true
    }

    override fun signUp(
        username: String,
        password: String,
        email: String,
        phoneNumber: String,
        resultListener: IServerRequestResultListener<SignInRequestResult>
    ) {
        val request = LogInServerRequest(urlForHostLoopbackInterface, username,password, scope)
        request.setServerRequestListener(resultListener)
        request.run()
    }

}