package me.apps.personal_account_npo_mir.view.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import me.apps.personal_account_npo_mir.presentation.login.SignInPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ISignInView
import me.apps.personal_account_npo_mir.view.main.instruments.InstrumentActivity
import me.apps.personalaccountnpomir.R

class LogInFragment :
    Fragment(),
    View.OnClickListener,
    ISignInView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    /**
     * Колбэк, вызываемый при создании View
     * В нем инициализируем переменные
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated(this)

        signInButton = view.findViewById(R.id.sign_in_button)
        loginEditText = view.findViewById(R.id.sign_in_login_edit_text)
        passwordEditText = view.findViewById(R.id.sign_in_password_edit_text)
        invalidTextView = view.findViewById(R.id.invalid_login_password_text_view)

        invalidTextView.visibility = View.GONE


        signInButton.setOnClickListener(this)
        progressBar = ButtonLoading(signInButton)
        loginEditText.setOnClickListener(this)
        passwordEditText.setOnClickListener(this)

        progressBar = ButtonLoading(view)
    }


    override fun onDestroy() {
        super.onDestroy()
        signInButton.setOnClickListener(null)
        presenter.onDestroy()
    }

    override fun onClick(view: View?) {
        if (view === signInButton) {
            presenter.onLoginTextChanged(loginEditText.text.toString())
            presenter.onPasswordChanged(passwordEditText.text.toString())
            presenter.onEnterButtonPressed()
            progressBar.setLoading()
        }
        if(view == loginEditText){
            progressBar.reset()

            // TODO: сделать ресет полей
            invalidTextView.visibility = View.GONE
        }
    }

    override fun setLoginBackground(resourceId: Int) {
        loginEditText.setBackgroundResource(resourceId)
    }

    override fun setPasswordBackground(resourceId: Int) {
        passwordEditText.setBackgroundResource(resourceId)
    }

    override fun setInvalidTextVisibilityTrue() {
        invalidTextView.visibility = View.VISIBLE
    }

    override fun setInvalidTextVisibilityFalse() {
        invalidTextView.visibility = View.GONE
    }

    override fun setStateFr(success : Boolean){
        progressBar.setState(success){}
    }

    override fun startMainActivity() {
        val intent = Intent(context, InstrumentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        activity?.finish()
    }

    private lateinit var progressBar: ButtonLoading
    private lateinit var signInButton: LinearLayoutCompat
    private lateinit var loginEditText: AppCompatEditText
    private lateinit var passwordEditText: AppCompatEditText
    private lateinit var invalidTextView: TextView
    private val presenter = SignInPresenter()


    companion object {
        /**
         * Фабричный метод для создания экземпляра фрагмента
         */
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}
