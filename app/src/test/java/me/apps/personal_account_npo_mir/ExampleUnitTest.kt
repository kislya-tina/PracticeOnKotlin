package me.apps.personal_account_npo_mir

import android.os.Environment
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.server_connect.ServerConnection
import me.apps.personal_account_npo_mir.view.login.LogRegActivity
import org.junit.Test
import org.junit.runner.manipulation.Ordering.Context
import java.io.File

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
   */
        @Test
        fun tokens(context:Context){
        //println(Environment.getExternalStorageDirectory())
        //val file = File(Environment.getExternalStorageDirectory()+"/path/to/myfile.txt")
        //file.writeText("This will be written to the file!")

        //val contents = file.readText() // Read file
        }
        @Test
        fun signIn() {
            val username = "user"
            val password = "password"
            val token: String = ServerConnection().signIn(username, password)
            println(token)
            val measure: Measure = Measure(100.0, 100.0, 100.0, 10.0, 1.0, "2023-07-20T05:35:16.675Z")
            println(ServerConnection().PutMeasure(10, token, measure))
            //println(Environment.getExternalStorageDirectory())
        }
        @Test
        fun PutMeasures() {
            println("EIGHTH TEST")
            val Token = "{\"SessionId\":137,\"Username\":\"user\"}.EF9B9C061914E814BC30CA48F278E505"
            val measure: Measure = Measure(1001212344.0, 11213423400.0, 1021423412340.0, 142423340.0, 1421342314.0, "2023-07-20T05:35:16.675Z")
            println(ServerConnection().PutMeasure(79, Token, measure))
        }

        @Test
        fun signUp() {
            val username = "user"
            val password = "password"
            println(ServerConnection().signUp(username, password))
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
        fun getLastMeasures() {
            println("SEVENTH TEST")
            val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"
            println(ServerConnection().getLastMeasures(1, Token))
        }

        @Test
        //done
        fun getDiagnostics() {
            println("SIXTH TEST")

            val Token = "{\"SessionId\":321,\"Username\":\"user\"}.8CD5FEAC4ED3C6C1C780318AABEFAF10"
            println(ServerConnection().getDiagnostics(2, Token))
        }

        @Test
        //done
        fun bindDevices() {
            println("FIFTH TEST")
            val Token = "{\"SessionId\":591,\"Username\":\"user\"}.472965FB24F3F97D4E08E9076E02C9AB"
            println(ServerConnection().bindDevices(2, Token))
        }
    }
