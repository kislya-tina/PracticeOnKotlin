package me.apps.personal_account_npo_mir.view.abstractions.login

interface ISignInView {
  /**
   * Установить фон поля "Логин"
   * @param resourceId ID ресурса
   */
  fun setLoginBackground(resourceId: Int)
  /**
   * Установить фон поля "Пароль"
   * @param resourceId ID ресурса
   */
  fun setPasswordBackground(resourceId: Int)

  /**
   * Запустить главное окно
   */
  fun startMainActivity()

  fun setInvalidTextVisibilityTrue()

  fun setInvalidTextVisibilityFalse()

  fun setStateFr(success : Boolean)
}