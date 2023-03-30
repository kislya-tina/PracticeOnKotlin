package me.apps.personal_account_npo_mir.view.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.login.LoginPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ILoginView
import me.apps.personalaccountnpomir.R

class LogRegActivity :
    AppCompatActivity(),
    //Реализуем интерфейс OnClickListener, для "прослушивания" колбэков нажатий на элементы управления
    View.OnClickListener,
    ILoginView{

    /**
     * Колбэк, вызываемый при создании Activity
     * Здесь проводим инициализацию необзодимых элементов
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Устанавливаем разметку UI
        setContentView(R.layout.activity_log_reg)
        //Выполняем поиск кнопки в разметке
        loginRegistrationSwitchButton = findViewById(R.id.login_registration_switch_button)
        //Устанавливаем Activity слушателем колбэков OnClick для кнопки-переключателя Вход/Регистрация
        loginRegistrationSwitchButton.setOnClickListener(this)
        //Выполняем поиск фрагментов входа и регистрации
        signInFragment = supportFragmentManager.findFragmentById(R.id.sign_in_fragment)!!
        signUpFragment = supportFragmentManager.findFragmentById(R.id.sign_up_fragment)!!
        //восстанавливаем состояние activity (переменную указывающую какой фрагмент в текущий момент показан на экране)
        presenter.onRestoreCurrentSwitchState(savedInstanceState?.getInt(CURRENT_SWITCH_BUTTON_STATE_PARAM_NAME))
        //выполняем настройку фрагментов
        presenter.onViewCreated(this)
    }

    /**
     * Колбэк для сохранения текущего состояния
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //Сохраняем текущее состояние фрагментов в bundle
        outState.putInt(CURRENT_SWITCH_BUTTON_STATE_PARAM_NAME, presenter.onSaveCurrentSwitchState())
    }

    /**
     * Колбэк, вызываемый при уничтожении Activity
     * Здесь освобождаем ресурсы
     */
    override fun onDestroy() {
        super.onDestroy()
        //Отписываемся от колбэков, для корректной работы сборщика мусора
        loginRegistrationSwitchButton.setOnClickListener(null)
        presenter.onDestroy()
    }

    /**
     * Колбэк, вызываемый при нажатии на элемент управления.
     * В текущей ситуации - кнопки Вход/Регистрация
     */
    override fun onClick(view: View?) {
        //Проверяем, что элемент на который нажали - это наша кнопка
        if (view == loginRegistrationSwitchButton) {
            presenter.onSwitchClick()
        }
    }

    /**
     * Функция показывающая/скрывающая фрагменты
     */
    private fun setVisibilityFragment(fragment: Fragment?, isVisible: Boolean) {
        //Проверяем фрагмент на null
        if (fragment === null) {
            return
        }
        //Начинаем транзакцию
        val t = supportFragmentManager.beginTransaction()
        t.setReorderingAllowed(true)
        //В зависимости от параметра
        if (isVisible) {
            //Показываем
            t.show(fragment)
        } else {
            //Скрываем
            t.hide(fragment)
        }
        //Коммитим транзакцию
        t.commit()
    }

    override fun showSignInFragment() {
        setVisibilityFragment(signInFragment, true)
        setVisibilityFragment(signUpFragment, false)

    }

    override fun showSignUpFragment() {
        setVisibilityFragment(signInFragment, false)
        setVisibilityFragment(signUpFragment, true)
    }

    override fun setSwitchText(valueResourceId: Int) {
        loginRegistrationSwitchButton.setText(valueResourceId)
    }

    private lateinit var signInFragment: Fragment
    private lateinit var signUpFragment: Fragment
    private lateinit var loginRegistrationSwitchButton: AppCompatButton
    private val presenter = LoginPresenter(App.loginService)

    companion object {
        //имя параметра для сохранения в bundle текущего состояния фрагментов
        private const val CURRENT_SWITCH_BUTTON_STATE_PARAM_NAME =
            "CURRENT_SWITCH_BUTTON_STATE_PARAM_NAME"
    }
}
