package me.apps.personal_account_npo_mir.presentation.abstraction

import me.apps.personal_account_npo_mir.view.abstractions.dialogs.IDialogView

interface ISupportDialogPresenter<TDialogView : IDialogView> {
    /**
     * Колбэк при создании диалога
     */
    fun onDialogCreate(view : TDialogView)

    /**
     * Колбэк при завершении работы диалога
     */
    fun onDialogDestroy()

    /**
     * Колбэк при нажатии кнопки "Ок"
     */
    fun onOkButtonClick()

    /**
     * Колбэк при нажатии кнопки "Отмена"
     */
    fun onCancelButtonClick()
}