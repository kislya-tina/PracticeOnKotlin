package me.apps.personal_account_npo_mir.view.abstractions.login

interface IRegistrationView {
    fun setLoginBackground(resourceID : Int)

    fun setPasswordBackground(resourceID : Int)

    fun setEmailBackground(resourceID : Int)

    fun setPhoneBackground(resourceID : Int)

    fun startMainActivity()
}