package me.apps.personal_account_npo_mir.view.abstractions.main

import android.app.Activity

/**
 * Интерфейс главного окна
 */
interface IMainView {
  /**
   * Установить заголовок окна
   * @param header текст заголовка
   */
  fun setHeader(header: String)

  /**
   * Перезагрузить список
   */
  fun refreshItems()

  fun startAnotherActivity(activity: Activity)
}