package me.apps.personal_account_npo_mir.view.main.meters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.view.abstractions.main.IMeterListViewItem
import me.apps.personalaccountnpomir.R

/**
 * Элемент списка устройств
 */
class MeterListViewHolder(view: View) :
  RecyclerView.ViewHolder(view),
  IMeterListViewItem {
  /**
   * Колбэк, вызываемый при привязке элемента к списку
   */
  fun onBind() {
    //В нем инициализируем переменные и элементы управления
//    nameTextView = itemView.findViewById(R.id.meter_name_text_view)
//    indicationsTextView = itemView.findViewById(R.id.meter_indications_text_view)
  }

  /**
   * Колбэк, вызываемый при очистке элемента управления
   */
  fun onCleanup() {
    //В нем освобождаем ресурсы
  }

  override fun setName(name: String) {
    nameTextView.text = name
  }

  override fun setIndications(value: String) {
    indicationsTextView.text = value
  }

  private lateinit var nameTextView : TextView
  private lateinit var indicationsTextView : TextView
}