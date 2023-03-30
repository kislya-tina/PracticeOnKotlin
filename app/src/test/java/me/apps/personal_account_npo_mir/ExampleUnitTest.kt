package me.apps.personal_account_npo_mir

import me.apps.personal_account_npo_mir.model.ServerConnection
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun SignIn(){
        val username = "user"
        val password = "password"
        println( ServerConnection().signIn(username,password))
    }
    @Test
    fun SignUp(){
        val username = "user"
        val password = "password"
        println( ServerConnection().signUp(username,password))
    }
}