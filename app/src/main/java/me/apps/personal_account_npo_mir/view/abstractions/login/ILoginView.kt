package me.apps.personal_account_npo_mir.view.abstractions.login
/**
 * Интерфейс представления Login
 */
interface ILoginView {
  /**
   * Показать фрагмент входа
   */
  fun showSignInFragment()

  /**
   * Показать фрагмент регистрации
   */
  fun showSignUpFragment()

  /**
   * Установить текст кнопки вход/регистрация
   */
  fun setSwitchText(valueResourceId: Int)
}