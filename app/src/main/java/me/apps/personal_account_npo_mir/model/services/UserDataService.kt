package me.apps.personal_account_npo_mir.model.services

import android.content.Context
import android.content.Intent
import me.apps.personal_account_npo_mir.di.App


import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ISignInView
import me.apps.personal_account_npo_mir.view.main.instruments.InstrumentActivity
import me.apps.personalaccountnpomir.R
import java.io.*
import java.nio.file.Files
import java.nio.file.StandardOpenOption


class UserDataService() : IUserDataService {
    // TODO: добавить в конструктор
    // TODO: нужно сделать через создание файла и записи туда токена/ов
    override var token: String
        get() = _token
        set(value) {
            _token = value
        }
    override var username: String
        get() = _username
        set(value) {
            _username = value
        }
    private var _token: String = ""
    private var _username: String = ""

}

