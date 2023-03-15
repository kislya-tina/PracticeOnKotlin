package me.apps.personal_account_npo_mir.view.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.login.LoginPresenter
import me.apps.personal_account_npo_mir.presentation.login.SignInPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ILoginView
import me.apps.personal_account_npo_mir.view.abstractions.login.ISignInView
import me.apps.personal_account_npo_mir.view.main.InstrumentActivity
import me.apps.personalaccountnpomir.R

class LogInFragment :
    Fragment(),
    View.OnClickListener,
    ISignInView{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    /**
     * Колбэк, вызываемый при создании View
     * В нем инициализируем переменные
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Ищем в разметке кнопку вход
        signInButton = view.findViewById(R.id.sign_in_button)
        //Устанавливаем текущий фрагмент слушателем колбэка OnClick кнопки вход
        signInButton.setOnClickListener(this)

        //Ищем поля ввода имени пользователя и пароля
        loginEditText = view.findViewById(R.id.sign_in_login_edit_text)
        passwordEditText = view.findViewById(R.id.sign_in_password_edit_text)
        //должен иметь ссылку на презентер
        presenter.onViewCreated(this)
    }

    /**
     * Колбэк при уничтожении фрагмента
     * В нем освобождаем ресурсы
     */
    override fun onDestroy() {
        super.onDestroy()
        //Удаляем слушателя OnClick кнопки вход
        signInButton.setOnClickListener(null)
        presenter.onDestroy()
    }

    /**
     * Колбэк, вызываемый при нажатии на элемент управления.
     * В текущей ситуации - кнопки Вход
     */
    override fun onClick(view: View?) {
        if (view === signInButton) {
            presenter.onLoginTextChanged(loginEditText.text.toString())
            presenter.onPasswordChanged(passwordEditText.text.toString())
            presenter.onEnterButtonPressed()
        }
    }

    /**
     * Функция валидации полей ввода
     */
    private fun validateIsEditTextEmpty(editText: AppCompatEditText): Boolean {
        return if (editText.text?.isBlank() == true) {
            editText.setBackgroundResource(R.drawable.ic_warning_frame)
            false
        } else {
            //иначе возвращаем исходный background
            editText.setBackgroundResource(R.drawable.ic_edit_text_background)
            true
        }
    }

    override fun setLoginBackground(resourceId: Int) {
        loginEditText.setBackgroundResource(resourceId)
    }

    override fun setPasswordBackground(resourceId: Int) {
        passwordEditText.setBackgroundResource(resourceId)
    }

    override fun startMainActivity() {
        val intent = Intent(context, InstrumentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        activity?.finish()
    }

    private lateinit var signInButton: AppCompatButton
    private lateinit var loginEditText: AppCompatEditText
    private lateinit var passwordEditText: AppCompatEditText
    private val presenter = SignInPresenter()

    companion object {
        /**
         * Фабричный метод для создания экземпляра фрагмента
         */
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}
