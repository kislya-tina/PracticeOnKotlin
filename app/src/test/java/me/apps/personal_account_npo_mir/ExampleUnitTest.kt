package me.apps.personal_account_npo_mir

import me.apps.personal_account_npo_mir.model.MetersService
import me.apps.personal_account_npo_mir.model.ServerConnect.ServerConnection
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.round
import kotlin.random.Random
import kotlin.random.nextInt

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
    @Test
    fun random(){
        println(Random.nextInt(0, 255))
        println(round(Random.nextDouble(0.toDouble(), 255.toDouble()) * 100.0) / 100.0)
        println(round(Random.nextDouble(0.toDouble(), 255.toDouble()) * 100.0) / 100.0)
        println(round(Random.nextDouble(0.toDouble(), 255.toDouble()) * 100.0) / 100.0)
        println(MetersService().getMeters("Паша"))
        println((1..10).map { Random.nextInt(1..9) }.joinToString(""))
        println(MetersService().GetLastMeasures(1, "d"))
    }
}