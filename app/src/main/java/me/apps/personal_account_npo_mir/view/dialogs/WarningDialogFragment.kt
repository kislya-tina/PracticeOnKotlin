package me.apps.personal_account_npo_mir.view.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.apps.personal_account_npo_mir.presentation.abstraction.ISupportWarningDialogPresenter
import me.apps.personal_account_npo_mir.view.abstractions.dialogs.BaseDialogFragment
import me.apps.personal_account_npo_mir.view.abstractions.dialogs.IWarningDialogView
import me.apps.personalaccountnpomir.R

class WarningDialogFragment(presenter : ISupportWarningDialogPresenter) :
    BaseDialogFragment<IWarningDialogView>(presenter),
        IWarningDialogView{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val dialogView = layoutInflater.inflate(R.layout.fragment_warning_dialog, contentDialogLayout)
        warningTextView = dialogView.findViewById(R.id.warning_message_text_view)
        return view
    }

    override fun setWarningMessage(messageId: Int) {
        warningTextView.setText(messageId)
    }

    override fun setWarningMessage(templateId: Int, message: String) {
        warningTextView.text = resources.getString(templateId, message)
    }

    override fun setWarningMessage(message: String) {
        warningTextView.text = message
    }

    override fun setWarningDrawable(drawableId: Int) {
        warningTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableId, 0, 0, 0)
    }

    private lateinit var warningTextView: TextView
}