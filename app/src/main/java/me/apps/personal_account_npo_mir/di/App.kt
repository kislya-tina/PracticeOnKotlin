package me.apps.personal_account_npo_mir.di

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import me.apps.personal_account_npo_mir.model.abstractions.ITokenService
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IArchiveDateService
import me.apps.personal_account_npo_mir.model.abstractions.diagnostic.IDiagnosticService
import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.model.abstractions.measures.IMeasureService
import me.apps.personal_account_npo_mir.model.abstractions.meters.IMetersService
import me.apps.personal_account_npo_mir.model.abstractions.user_data.IUserDataService
import me.apps.personal_account_npo_mir.model.server_connect.TokenService
import me.apps.personal_account_npo_mir.model.services.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        userDataService = UserDataService()
        networkScope = CoroutineScope(Dispatchers.IO)
        measuresService = MeasuresService(networkScope)
        loginService = SignInService(networkScope)
        tokenService = TokenService(applicationContext)
        archiveDateService = ArchiveDateService()
        metersService = MetersService(networkScope)
    }

    // TODO: если токен есть в файл, пропускать первую активити

    companion object {
        lateinit var tokenService: ITokenService
        lateinit var measuresService: IMeasureService
        lateinit var loginService: ILoginService
        lateinit var userDataService: IUserDataService
        lateinit var networkScope: CoroutineScope
        lateinit var archiveDateService: IArchiveDateService
        lateinit var metersService: IMetersService
        lateinit var archiveDateService: IArchiveDateService
        lateinit var diagnosticService: IDiagnosticService
        lateinit var userDataService: IUserDataService
    }
}