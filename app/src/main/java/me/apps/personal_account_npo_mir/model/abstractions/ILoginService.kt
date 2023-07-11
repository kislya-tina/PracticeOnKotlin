package me.apps.personal_account_npo_mir.model.abstractions

interface ILoginService {
    fun signIn(
        username: String,
        password: String
    ): String

    fun signOut(): Boolean

    fun signUp(
        username: String,
        password: String,
        email: String,
        phoneNumber: String
    ): String

    var username: String
    var token: String
}