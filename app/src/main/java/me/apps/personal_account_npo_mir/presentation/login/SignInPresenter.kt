package me.apps.personal_account_npo_mir.presentation.login

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.signin.SignInRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ISignInView
import me.apps.personalaccountnpomir.R

class SignInPresenter : IPresenter<ISignInView>, IServerRequestResultListener<SignInRequestResult> {

    override fun onViewCreated(view: ISignInView) {
        this.view = view
    }

    override fun onDestroy() {
        view = null
    }
    override fun onRequestSuccess(result: SignInRequestResult) {
        App.userDataService.token = result.token
        App.userDataService.username = result.username
        view?.startMainActivity()
    }

    override fun onRequestFail(message: ErrorCode) {
        /*if(enum == incorrect401) {
            view?.setLoginBackground(R.drawable.ic_warning_frame)
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
        }

        if(enum == 404){
            dialog
        }*/
    }

    /**
     * Колбэк при изменении текста в поле "Логин"
     */
    fun onLoginTextChanged(login: String) {
        this.username = login
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
        if (username.isBlank()){
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

        if (success) {
            App.loginService.signIn(username, password, this)
            view?.setStateFr(true)

        } else {
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