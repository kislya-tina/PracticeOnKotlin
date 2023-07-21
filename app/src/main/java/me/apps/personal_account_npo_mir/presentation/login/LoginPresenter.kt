package me.apps.personal_account_npo_mir.presentation.login

import me.apps.personal_account_npo_mir.model.abstractions.login.ILoginService
import me.apps.personal_account_npo_mir.presentation.abstraction.IPresenter
import me.apps.personal_account_npo_mir.view.abstractions.login.ILoginView
import me.apps.personalaccountnpomir.R


class LoginPresenter(private val loginService: ILoginService) : IPresenter<ILoginView> {
    /**
     * @inheritDoc
     */
    override fun onViewCreated(view: ILoginView) {
        this.view = view
        setupFragments()
    }

    /**
     * @inheritDoc
     */
    override fun onDestroy() {
        view = null
    }

    /**
     * Колбэк при вызове сохранения текущего состояния фрагментов
     */
    fun onSaveCurrentSwitchState(): Int = currentSwitchButtonState

    /**
     * Колбэк при вызове восстановления текущего состояния фрагментов
     */
    fun onRestoreCurrentSwitchState(currentSwitchState: Int?) {
        if(currentSwitchState === null){
            return
        }
        if (currentSwitchButtonState != currentSwitchState) {
            currentSwitchButtonState = currentSwitchState
            setupFragments()
        }
    }

    /**
     * Колбэк при нажатии на кнопку переключения фрагментов вход/регистрация
     */
    fun onSwitchClick() {
        //Инвертируем текущее состояние
        currentSwitchButtonState = if (currentSwitchButtonState == SIGN_IN_STATE) {
            SIGN_UP_STATE
        } else {
            SIGN_IN_STATE
        }
        //выполняем настройку фрагментов
        setupFragments()
    }

    /**
     * Установить фрагменты
     */
    private fun setupFragments() {
        //Проверяем текущее состояние кнопки
        if (currentSwitchButtonState == SIGN_IN_STATE) {
            //если должен быть показан фрагмент входа
            //показываем фрагмент входа
            view?.showSignInFragment()
            //Меняем текст кнопки на "регистрация"
            view?.setSwitchText(R.string.registration)

        } else {
            //если должен быть показан фрагмент регистрации
            //показываем фрагмент регистрации
            view?.showSignUpFragment()
            //Меняем текст кнопки на "вход"
            view?.setSwitchText(R.string.sign_in)
        }
    }

    private var view: ILoginView? = null

    //Переменная, указывающая какой фрагмент в текущий момент показан на экране
    private var currentSwitchButtonState = SIGN_IN_STATE

    companion object {
        private const val SIGN_IN_STATE = 0 //Фрагмент вход
        private const val SIGN_UP_STATE = 1 //фрагмент регистрация
    }

}