package me.apps.personal_account_npo_mir.di

import android.app.Application
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IArchiveDateService
import me.apps.personal_account_npo_mir.model.services.LoginService
import me.apps.personal_account_npo_mir.model.services.MetersService
import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService
import me.apps.personal_account_npo_mir.model.services.ArchiveDateService
import me.apps.personal_account_npo_mir.model.services.UserDataService

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        loginService = LoginService()
        metersService = MetersService()
        userDataService = UserDataService()
        archiveDateService = ArchiveDateService()
    }

    companion object {
        lateinit var loginService: ILoginService
        lateinit var metersService: IMetersService
        lateinit var userDataService: IUserDataService
        lateinit var archiveDateService: IArchiveDateService
    }
}