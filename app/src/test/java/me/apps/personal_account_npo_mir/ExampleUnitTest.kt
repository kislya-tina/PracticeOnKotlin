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
   /*
    @Test
    //400
    fun FindDevices(){
        println("FOURTH TEST")
        val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"
        println(Back().FindDevices(12345678, 10, Token))
    }
    @Test
    fun PutMeasures(){
        println("EIGHTH TEST")
        val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"
        //println(Back().PutMeasure(2,Token))
    }*/
    @Test
    fun signIn(){
        val username = "user"
        val password = "password"
        println( ServerConnection().signIn(username,password))
    }
    @Test
    fun signUp(){
        val username = "user"
        val password = "password"
        println( ServerConnection().signUp(username,password))
    }
    @Test
    fun random(){
        println(MetersService().getMeters("Паша"))
        println(MetersService().getLastMeasures(1, "d"))
    }
    @Test
    //done
    fun getMeters() {
        println("THIRD TEST")
        val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"

        println(ServerConnection().getMeters(Token))
    }
    @Test
    //done
    fun getLastMeasures(){
        println("SEVENTH TEST")
        val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"
        println(ServerConnection().getLastMeasures(1,Token))
    }
    @Test
    //done
    fun getDiagnostics(){
        println("SIXTH TEST")

        val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"
        println(ServerConnection().getDiagnostics(2, Token))
    }
    @Test
    //done
    fun bindDevices(){
        println("FIFTH TEST")
        val Token = "{\"SessionId\":591,\"Username\":\"user\"}.472965FB24F3F97D4E08E9076E02C9AB"
        println(ServerConnection().bindDevices(2,Token))
    }
}