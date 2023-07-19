package me.apps.personal_account_npo_mir.view.main.dates

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.model.abstractions.archive_date.IDateListViewItem
import me.apps.personal_account_npo_mir.presentation.main.activity_presenters.ArchivePresenter
import me.apps.personalaccountnpomir.R
import java.text.SimpleDateFormat
import java.util.*

class DatesListViewHolder(val presenter: ArchivePresenter, view: View) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener,
        IDateListViewItem {
    fun onBind(){
        dateTextView = itemView.findViewById(R.id.date_text_view)
        itemView.setOnClickListener(this)
    }

    fun onCleanUp(){
        // TODO: найти где это использовать 
        itemView.setOnClickListener(null)
    }

    override fun onClick(view: View?) {
        if(view === itemView){
            presenter.onItemClick(adapterPosition)
        }
    }

    override fun setDate(value: Long) {
        val date = Date(value)
        val format = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

        dateTextView.text = format.format(date)
    }



    private lateinit var dateTextView : TextView
}