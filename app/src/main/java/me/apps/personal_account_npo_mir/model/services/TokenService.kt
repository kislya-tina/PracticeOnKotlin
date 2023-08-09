package me.apps.personal_account_npo_mir.model.services

import android.content.Context
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.user_data.ITokenService
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class TokenService(override var app: Context) : ITokenService {
    override var token: String
        get() = _token
        set(value) {
            _token = value
        }
    private var _token: String = ""

    init {
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
            val token = file.readText()
            println(token)
            App.userDataService.token = token
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun saveToken(token: String) {
        val path = app.getFilesDir()
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "tokens.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
        val bw = BufferedWriter(FileWriter(file))
        if (file.readText() != null) {
            bw.write(token)
            bw.newLine()
        }
        bw.close()
    }

    override fun deleteToken() {
        val path = app.getFilesDir()
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "tokens.txt")
        if (file.exists()) {
            file.delete()
        }
        token = ""
    }
}