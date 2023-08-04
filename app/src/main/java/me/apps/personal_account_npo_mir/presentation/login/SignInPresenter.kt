package me.apps.personal_account_npo_mir.presentation.login

import com.google.gson.Gson
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.abstractions.measures.Measure
import me.apps.personal_account_npo_mir.model.abstractions.meters.Meter
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.get_last_measure.GetLastMeasureRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.get_meters.GetMetersRequestResult
import me.apps.personal_account_npo_mir.model.server_connect.sign_in.SignInRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ISignInView
import me.apps.personalaccountnpomir.R
import java.io.IOException

class SignInPresenter() : IPresenter<ISignInView>,
    IServerRequestResultListener<SignInRequestResult>{

    object SaveMeters: IServerRequestResultListener<GetMetersRequestResult>{

        override fun onRequestSuccess(result: GetMetersRequestResult) {
            val meters:Array<Meter> = Gson().fromJson(result.meters, Array<Meter>::class.java)
            App.metersService.saveMeters(meters)
            for (meter in App.metersService.meters) {
                App.measuresService.getLastMeasure(
                    meter.id.toInt(),
                    App.userDataService.token,
                    SaveLastMeasures
                )
            }
        }

        override fun onRequestFail(message: ErrorCode) {
            println("Meters Service is empty")
        }

    }
    object SaveLastMeasures:IServerRequestResultListener<GetLastMeasureRequestResult>{
        override fun onRequestSuccess(result: GetLastMeasureRequestResult) {
            try {
                val measure: Measure = Gson().fromJson(result.measure, Measure::class.java)
                App.measuresService.saveMeasures(measure)
            }catch (e:Exception){
                println("Measure for this meter is not exist")
            }
        }

        override fun onRequestFail(message: ErrorCode) {
            TODO("Not yet implemented")
        }
    }


    /**
     * Колбэк при создании View
     */
    override fun onViewCreated(view: ISignInView) {
        this.view = view
        if (App.userDataService.token.isNotEmpty()) {
            App.metersService.getMeters(App.userDataService.token, SaveMeters)
            view.startMainActivity()
        }
    }

    /**
     * Колбэк при завершении работы презентера
     */
    override fun onDestroy() {
        view = null
    }

    /**
     * Колбэк при положительном ответе с сервера
     */
    override fun onRequestSuccess(result: SignInRequestResult) {
        App.userDataService.token = result.token
        App.userDataService.username = result.username
        App.tokenService.saveToken(result.token)
        App.metersService.getMeters(App.userDataService.token, SaveMeters)

        //Установка серых рамок и скрытие текста
        view?.setStateFr(true)
        view?.setLoginBackground(R.drawable.rectangle_reg)
        view?.setPasswordBackground(R.drawable.rectangle_reg)
        view?.setInvalidTextVisibilityFalse()
        //Запуск следующей активити
        view?.startMainActivity()
    }

    /**
     * Колбэк при отрицательном ответе с сервера
     */
    override fun onRequestFail(message: ErrorCode) {
        //Установка красных рамок и вывод текста
        view?.setStateFr(false)
        view?.setLoginBackground(R.drawable.ic_warning_frame)
        view?.setPasswordBackground(R.drawable.ic_warning_frame)
        view?.setInvalidTextVisibilityTrue()
    }

    /**
     * Колбэк при изменении текста в поле "login"
     */
    fun onLoginTextChanged(login: String) {
        this.username = login
        view?.setInvalidTextVisibilityFalse()
        view?.setLoginBackground(R.drawable.rectangle_reg)
    }

    /**
     * Колбэк при изменении текста в поле "password"
     */
    fun onPasswordChanged(password: String) {
        this.password = password
        view?.setInvalidTextVisibilityFalse()
        view?.setPasswordBackground(R.drawable.rectangle_reg)
    }

    /**
     * Колбэк при нажатии на кнопку "Вход"
     */
    fun onEnterButtonPressed() {
        var success = true
        //Проверка текста в поле "username"
        if (username.isBlank()) {
            success = false
            view?.setLoginBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setLoginBackground(R.drawable.rectangle_reg)
        }
        //Проверка текста в поле "password"
        if (password.isBlank()) {
            success = false
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPasswordBackground(R.drawable.rectangle_reg)
        }
        if (success) {
            //Обращение к серверу
            App.loginService.signIn(username, password, this)
        } else {
            //Установка красных рамок и вывод текста
            view?.setStateFr(false)
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
            view?.setLoginBackground(R.drawable.ic_warning_frame)
            view?.setInvalidTextVisibilityTrue()
        }
    }

    private var username: String = ""
    private var password: String = ""
    private var view: ISignInView? = null
}