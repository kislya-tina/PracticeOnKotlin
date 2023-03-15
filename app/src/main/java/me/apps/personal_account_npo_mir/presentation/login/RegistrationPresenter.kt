package me.apps.personal_account_npo_mir.presentation.login

import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.IRegistrationView
import me.apps.personalaccountnpomir.R

class RegistrationPresenter : IPresenter<IRegistrationView> {
    override fun onViewCreated(view: IRegistrationView) {
        this.view = view
    }

    override fun onDestroy() {
        this.view = null
        login = ""
        password = ""
        email = ""
        phone = ""
    }

    fun onLoginTextChanged(login : String){
        this.login = login
    }

    fun onPasswordChanged(password: String) {
        this.password = password
    }

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun onPhoneChanged(phone: String) {
        this.phone = phone
    }

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

        if (email.isBlank()){
            success = false
            view?.setEmailBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setEmailBackground(R.drawable.ic_edit_text_background)
        }

        if (phone.isBlank()){
            success = false
            view?.setPhoneBackground(R.drawable.ic_warning_frame)
        } else {
            view?.setPhoneBackground(R.drawable.ic_edit_text_background)
        }

        if(success) {
            App.loginService.signUp(login, password, email, phone)
            view?.startMainActivity()
        }
    }

    private var login: String = ""
    private var password: String = ""
    private var email: String = ""
    private var phone: String = ""

    private var view : IRegistrationView? = null}