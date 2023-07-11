package me.apps.personal_account_npo_mir.model.ServerConnect

import me.apps.personal_account_npo_mir.model.abstractions.ILoginService

class ServerConnectionStub(override var username: String, override var token: String) : ILoginService {
    override fun signIn(username: String, password: String): Boolean {
        return username=="user"&&password=="password" ||username=="vika"&&password=="777"||username=="ramazan"&&password=="12345678"
    }
    override fun signOut(): Boolean {
        TODO("Not yet implemented")
    }
    override fun signUp(
        username: String,
        password: String,
        email: String,
        phoneNumber: String
    ): Boolean {
        return username!="user"||username!="vika"||username!="ramazan"
    }
}