package me.apps.personal_account_npo_mir.view.abstractions.dialogs

interface IWarningDialogView : IDialogView{

    fun setWarningMessage(messageId: Int){

    }

    fun setWarningMessage(templateId: Int, message: String){

    }

    fun setWarningMessage(message: String){

    }

    fun setWarningDrawable(drawableId: Int){

    }
}