package me.apps.personal_account_npo_mir.view.main.activities.diagnostic

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.model.abstractions.diagnostic.IDiagnosticListViewItem
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.DiagnosticPresenter
import me.apps.personalaccountnpomir.R

class DiagnosticItemLIstViewHolder(val presenter: DiagnosticPresenter, view: View) :
    RecyclerView.ViewHolder(view), IDiagnosticListViewItem {

    fun onBind() {
        codeTextView = itemView.findViewById(R.id.codeText)
        errorTextView = itemView.findViewById(R.id.errorText)
    }

    override fun setCode(errorId: Int) {
        codeTextView.text = "00"
       // codeTextView.text = errorId.toString()
    }

    override fun setError(errorText: String) {
        errorTextView.text = "Диагностика прошла успешно"
       // errorTextView.text = errorText
    }

    override fun setImage(boolean: Boolean){
        presenter.setImage(boolean)
    }

    private lateinit var codeTextView: TextView
    private lateinit var errorTextView: TextView

}