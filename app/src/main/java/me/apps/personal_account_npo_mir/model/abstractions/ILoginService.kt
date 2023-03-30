package me.apps.personal_account_npo_mir.model.abstractions

interface ILoginService {
    fun signIn(
        username: String,
        password: String
    ): Boolean

    fun signOut()

    fun signUp(
        username: String,
        password: String,
        email: String,
        phoneNumber: String
    )

    var username: String
    var token: String
}