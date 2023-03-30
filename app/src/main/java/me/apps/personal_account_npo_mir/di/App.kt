package me.apps.personal_account_npo_mir.di

import android.app.Application
import me.apps.personal_account_npo_mir.model.LoginService
import me.apps.personal_account_npo_mir.model.MetersService
import me.apps.personal_account_npo_mir.model.abstractions.ILoginService
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        loginService = LoginService()
        metersService = MetersService()
    }

    companion object {
        lateinit var loginService: ILoginService
        lateinit var metersService: IMetersService
    }
}