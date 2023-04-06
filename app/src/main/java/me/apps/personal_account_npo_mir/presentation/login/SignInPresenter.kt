package me.apps.personal_account_npo_mir.presentation.login

import android.widget.Toast
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ISignInView
import me.apps.personal_account_npo_mir.view.main.InstrumentActivity
import me.apps.personal_account_npo_mir.view.main.InstrumentFragment
import me.apps.personalaccountnpomir.R
import kotlin.coroutines.coroutineContext

class SignInPresenter : IPresenter<ISignInView> {

    override fun onViewCreated(view: ISignInView) {
        this.view = view
    }

    override fun onDestroy() {
        view = null
    }

    /**
     * Колбэк при изменении текста в поле "Логин"
     */
    fun onLoginTextChanged(login: String) {
        this.login = login
    }

    /**
     * Колбэк при изменении текста в поле "Пароль"
     */
    fun onPasswordChanged(password: String) {
        this.password = password
    }

    /**
     * Колбэк при нажатии на кнопку "Вход"
     */
    fun onEnterButtonPressed() {
        var success = true
        if (login.isBlank()){
            success = false
            view?.setLoginBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setLoginBackground(R.drawable.rectangle_reg)
        }

        if (password.isBlank()){
            success = false
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPasswordBackground(R.drawable.rectangle_reg)
        }

        if(success && App.loginService.signIn(login, password)){
//            token = App.loginService.getToken()
            view?.startMainActivity()
        }
    }

    private var login: String = ""
    private var password: String = ""
    private var token: String = ""

    private var view: ISignInView? = null
}