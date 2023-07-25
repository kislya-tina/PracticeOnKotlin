package me.apps.personal_account_npo_mir.presentation.login

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.signin.SignInRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.IRegistrationView
import me.apps.personalaccountnpomir.R

class RegistrationPresenter : IPresenter<IRegistrationView>,
    IServerRequestResultListener<SignInRequestResult> {
    override fun onViewCreated(view: IRegistrationView) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
        login = ""
        password = ""
        repeatedPassword = ""
        phone = ""
    }

    fun onLoginTextChanged(login : String){
        this.login = login
    }

    fun onPasswordChanged(password: String) {
        this.password = password
    }

    fun onRepeatPasswordChanged(password: String) {
        this.repeatedPassword = password
    }

    fun onPhoneChanged(phone: String) {
        this.phone = phone
    }

    /**
     * Колбэк при нажатии на кнопку "Регистрация"
     */
    fun onRegisterButtonClick(){
        var success = true
        if (login.isBlank()){
            success = false
            view?.setLoginBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setLoginBackground(R.drawable.ic_edit_text_background)
        }

        if (password.isBlank()){
            success = false
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPasswordBackground(R.drawable.ic_edit_text_background)
        }

        if (repeatedPassword.isBlank()){
            success = false
            view?.setRepeatPasswordBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setRepeatPasswordBackground(R.drawable.ic_edit_text_background)
        }

        if (phone.isBlank()){
            success = false
            view?.setPhoneBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPhoneBackground(R.drawable.ic_edit_text_background)
        }


        if(password != repeatedPassword){
            success = false
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
            view?.setRepeatPasswordBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPasswordBackground(R.drawable.ic_edit_text_background)
            view?.setRepeatPasswordBackground(R.drawable.ic_edit_text_background)
        }

        if(success) {
            App.loginService.signUp(login, password, phone, this)

        }
    }

    override fun onRequestSuccess(result: SignInRequestResult) {
        App.userDataService.token = result.token
        App.userDataService.username = result.username
        view?.startMainActivity()
    }

    override fun onRequestFail(message: ErrorCode) {


    }

    private var login: String = ""
    private var phone: String = ""
    private var password: String = ""
    private var repeatedPassword: String = ""

    private var token: String = ""
    private var view : IRegistrationView? = null
}