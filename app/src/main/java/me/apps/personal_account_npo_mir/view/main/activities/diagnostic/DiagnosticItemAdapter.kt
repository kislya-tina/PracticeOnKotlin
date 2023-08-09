package me.apps.personal_account_npo_mir.view.main.activities.diagnostic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.DiagnosticPresenter
import me.apps.personalaccountnpomir.R

class DiagnosticItemAdapter(private val presenter: DiagnosticPresenter):
    RecyclerView.Adapter<DiagnosticItemLIstViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiagnosticItemLIstViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_diagnostic, parent, false)

        return DiagnosticItemLIstViewHolder(presenter, view)

    }

    override fun onBindViewHolder(holder: DiagnosticItemLIstViewHolder, position: Int) {
        holder.onBind()
        presenter
    }


    override fun getItemCount(): Int {
        return 1
    }
}