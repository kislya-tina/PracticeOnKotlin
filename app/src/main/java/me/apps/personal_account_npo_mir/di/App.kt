package me.apps.personal_account_npo_mir.di

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.apps.personal_account_npo_mir.model.services.SignInService
import me.apps.personal_account_npo_mir.model.services.MetersService
import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.abstractions.measures.ImeasureService
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService
import me.apps.personal_account_npo_mir.model.services.MeasuresService
import me.apps.personal_account_npo_mir.model.services.UserDataService

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        networkScope = CoroutineScope(Dispatchers.IO)
        measuresService = MeasuresService(networkScope)
        loginService = SignInService(networkScope)
        metersService = MetersService(networkScope)
        userDataService = UserDataService()
    }
    // TODO: если токен есть в референс, пропускать первую активити

    companion object {
        lateinit var measuresService:ImeasureService
        lateinit var loginService: ILoginService
        lateinit var metersService: IMetersService
        lateinit var userDataService: IUserDataService
        lateinit var networkScope:CoroutineScope
    }
}