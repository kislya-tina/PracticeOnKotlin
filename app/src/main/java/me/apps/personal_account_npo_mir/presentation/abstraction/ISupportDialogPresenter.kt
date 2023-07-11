package me.apps.personal_account_npo_mir.presentation.abstraction

import me.apps.personal_account_npo_mir.view.abstractions.dialogs.IDialogView

interface ISupportDialogPresenter<TDialogView : IDialogView> {
    fun onDialogCreate(view : TDialogView)

    fun onDialogDestroy()

    fun onOkButtonClick()

    fun onCancelButtonClick()
}