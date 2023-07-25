package me.apps.personal_account_npo_mir.di

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IArchiveDateService
import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.abstractions.measures.ImeasureService
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService
import me.apps.personal_account_npo_mir.model.services.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        networkScope = CoroutineScope(Dispatchers.IO)
        loginService = SignInService(networkScope)
        measuresService = MeasuresService(networkScope)
        metersService = MetersService(networkScope)
        archiveDateService = ArchiveDateService()
        userDataService = UserDataService()
    }
    // TODO: если токен есть в файл, пропускать первую активити

    companion object {
        lateinit var networkScope:CoroutineScope
        lateinit var loginService: ILoginService
        lateinit var measuresService:ImeasureService
        lateinit var metersService: IMetersService
        lateinit var archiveDateService: IArchiveDateService
        lateinit var userDataService: IUserDataService
    }
}