package me.apps.personal_account_npo_mir.model.ServerConnect

class ServerConnectionStub : IServerConnection {
    override fun signIn(username: String, password: String): String {
        if(username=="user"&&password=="password" ||username=="vika"&&password=="777"||username=="ramazan"&&password=="12345678")
            return username
        else return "Unauthorized"
    }

    override fun signUp(username: String, password: String): String {
        if(username!="user"||username!="vika"||username!="ramazan")
            return username
        else return "Authorized"
    }
}