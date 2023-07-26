package me.apps.personal_account_npo_mir.view.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import me.apps.personal_account_npo_mir.presentation.login.RegistrationPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.IRegistrationView
import me.apps.personal_account_npo_mir.view.main.instruments.InstrumentActivity
import me.apps.personalaccountnpomir.R

class RegistrationFragment :
    Fragment(),
    View.OnClickListener,
    IRegistrationView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpButton = view.findViewById(R.id.sign_up_button)
        signUpButton.setOnClickListener(this)

        loginEditText = view.findViewById(R.id.sign_up_username_edit_text)
        passwordEditText = view.findViewById(R.id.sign_up_password_edit_text)
        phoneEditText = view.findViewById(R.id.sign_up_phone_edit_text)
        repeatPasswordEditText = view.findViewById(R.id.sign_up_repeat_password_edit_text)

        presenter.onViewCreated(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        signUpButton.setOnClickListener(null)
        presenter.onDestroy()
    }

    override fun onClick(view: View?) {
        if (view === signUpButton) {
            presenter.onLoginTextChanged(loginEditText.text.toString())
            presenter.onPhoneChanged(phoneEditText.text.toString())
            presenter.onPasswordChanged(passwordEditText.text.toString())
            presenter.onRepeatPasswordChanged(repeatPasswordEditText.text.toString())
            presenter.onRegisterButtonClick()
        }
    }

    override fun setLoginBackground(resourceID : Int){
        loginEditText.setBackgroundResource(resourceID)
    }

    override fun setPasswordBackground(resourceID : Int){
        passwordEditText.setBackgroundResource(resourceID)
    }

    override fun setRepeatPasswordBackground(resourceID : Int){
        repeatPasswordEditText.setBackgroundResource(resourceID)
    }

    override fun setPhoneBackground(resourceID : Int){
        phoneEditText.setBackgroundResource(resourceID)
    }

    override fun startMainActivity(){
        val intent = Intent(context, InstrumentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        activity?.finish()
    }

    private lateinit var signUpButton: AppCompatButton
    private lateinit var loginEditText: AppCompatEditText
    private lateinit var passwordEditText: AppCompatEditText
    private lateinit var phoneEditText: AppCompatEditText
    private lateinit var repeatPasswordEditText: AppCompatEditText
    private val presenter = RegistrationPresenter()

    companion object {
        @JvmStatic
        fun newInstance() =
            RegistrationFragment()
    }
}