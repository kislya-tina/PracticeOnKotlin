package me.apps.personal_account_npo_mir.presentation.login

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.model.server_connect.ErrorCode
import me.apps.personal_account_npo_mir.model.server_connect.abstractions.IServerRequestResultListener
import me.apps.personal_account_npo_mir.model.server_connect.sign_in.SignInRequestResult
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.IRegistrationView
import me.apps.personalaccountnpomir.R

class RegistrationPresenter : IPresenter<IRegistrationView>,
    IServerRequestResultListener<SignInRequestResult> {
    /**
     * Колбэк при создании View
     */
    override fun onViewCreated(view: IRegistrationView) {
        this.view = view
    }

    /**
     * Колбэк при завершении работы презентера
     */
    override fun onDestroy() {
        this.view = null
        login = ""
        password = ""
        email = ""
        phone = ""
    }

    /**
     * Колбэк при изменении текста в поле "login"
     */
    fun onLoginTextChanged(login: String) {
        this.login = login
    }

    /**
     * Колбэк при изменении текста в поле "password"
     */
    fun onPasswordChanged(password: String) {
        this.password = password
    }

    /**
     * Колбэк при изменении текста в поле "email"
     */
    fun onEmailChanged(email: String) {
        this.email = email
    }

    /**
     * Колбэк при изменении текста в поле "phone"
     */
    fun onPhoneChanged(phone: String) {
        this.phone = phone
    }

    /**
     * Колбэк при нажатии на кнопку "Регистрация"
     */
    fun onRegisterButtonClick() {
        var success = true
        //Проверка текста в поле "login"
        if (login.isBlank()) {
            success = false
            view?.setLoginBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setLoginBackground(R.drawable.ic_edit_text_background)
        }
        //Проверка текста в поле "password"
        if (password.isBlank()) {
            success = false
            view?.setPasswordBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPasswordBackground(R.drawable.ic_edit_text_background)
        }
        //Проверка текста в поле "email"
        if (email.isBlank()) {
            success = false
            view?.setEmailBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setEmailBackground(R.drawable.ic_edit_text_background)
        }
        //Проверка текста в поле "phone"
        if (phone.isBlank()) {
            success = false
            view?.setPhoneBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPhoneBackground(R.drawable.ic_edit_text_background)
        }

        if (success) {
            //Обращение к серверу
            App.loginService.signUp(login, password, email, phone, this)
        }
    }

    /**
     * Колбэк при положительном ответе с сервера
     */
    override fun onRequestSuccess(result: SignInRequestResult) {
        App.userDataService.token = result.token
        App.userDataService.username = result.username
        view?.startMainActivity()
    }

    /**
     * Колбэк при отрицательном ответе с сервера
     */
    override fun onRequestFail(message: ErrorCode) {
        // TODO: реализовать функцию
        // TODO: сделать исключения
    }

    private var login: String = ""
    private var password: String = ""
    private var email: String = ""
    private var phone: String = ""
    private var view: IRegistrationView? = null
}
