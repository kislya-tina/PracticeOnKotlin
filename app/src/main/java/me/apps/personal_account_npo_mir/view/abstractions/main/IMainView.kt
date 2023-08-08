package me.apps.personal_account_npo_mir.view.abstractions.main

import android.app.Activity

/**
 * Интерфейс главного окна
 */
interface IMainView {
    /**
     * Перезагрузить список
     */
    fun refreshItems()

    /**
     * Установить заголовок окна
     * @param header текст заголовка
     */
    fun setHeader(header: String)

    /**
     * Запустить окно архива
     */
    fun startArchiveActivity()

    /**
     * Запустить окно диагностики
     */
    fun startDiagnosticActivity()

    /**
     * Запустить окно передачи показаний
     */
    fun startTransmittalActivity()

  /**
   * Запустить окно информации
   */
  fun startInformationActivity()

  fun startSearchDevicesActivity()
  fun startLogRegActivity()
}