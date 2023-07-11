package me.apps.personal_account_npo_mir.model.abstractions.login

interface ILoginService {
    fun signIn(
        username: String,
        password: String
    ): Boolean

    fun signOut(): Boolean

    fun signUp(
        username: String,
        password: String,
        email: String,
        phoneNumber: String
    ): Boolean

    var username: String

}