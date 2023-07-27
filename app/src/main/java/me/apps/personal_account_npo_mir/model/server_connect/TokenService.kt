package me.apps.personal_account_npo_mir.model.server_connect

import android.content.Context
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.ITokenService
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class TokenService(app:Context):ITokenService {
    override var token: String
        get() = _token
        set(value) {
            _token = value
        }
    private var _token: String = ""
    //override fun tokenCheck(app: Context): String {
    init{
        try {
            //получаем директорию
            val path = app.getFilesDir()
            //создаем свою директорию
            val letDirectory = File(path, "LET")
            letDirectory.mkdirs()
            //создаем наш файл
            val file = File(letDirectory, "tokens.txt")
            //проверяем файл на существование
            if (!file.exists()) {
                file.createNewFile()
            } else {
                println("file is already exist")
            }
            //создаем ридер и врайтер
            val bw = BufferedWriter(FileWriter(file, true))
            //запись в файл, если файл пустой(невозможно сделать это отсюда)
            /*
            if (file.readText() == null) {
                bw.write("token")
                bw.newLine()
                //bw.flush()
                println("NOW TOKEN IS NOT EMPTY")
                return ""
            }*/
            //чтение токена, если файл не пустой
            //else {
            var tkn = file.readText()
            println(tkn)
            //return tkn
            App.userDataService.token = tkn
            println("TOKEN IS NOT EMPTY")
            //}
            bw.close()
        } catch (e: Exception) {
            e.printStackTrace()
            println("ERROR")
            //return ""
        }
    }
}