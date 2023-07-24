package me.apps.personal_account_npo_mir.model.abstractions.login

import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.signIn.SignInRequestResult

interface ILoginService {
    fun signIn(
        username: String,
        password: String,
        resultListener: IServerRequestResultListener<SignInRequestResult>
    )

    fun signOut(): Boolean

    fun signUp(
        username: String,
        password: String,
        email: String,
        phoneNumber: String,
        resultListener: IServerRequestResultListener<SignInRequestResult>
    )



}