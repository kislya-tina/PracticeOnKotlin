package me.apps.personal_account_npo_mir.view.main.meters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.apps.personal_account_npo_mir.presentation.main.MainPresenter
import me.apps.personalaccountnpomir.R

/**
 * Адаптер списка устройств
 */
class MetersRowAdapter(private val presenter: MainPresenter) : RecyclerView.Adapter<MeterListViewHolder>() {
  /**
   * Колбэк, вызываемый при создании элемента списка
   */
  /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeterListViewHolder {
    //создаем элемент списка в разметке
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.row_item_meter, parent, false)
    //возвращаем ViewHolder этого элемента
    return MeterListViewHolder(view)
  }*/

  /**
   * Колбэк, вызываемый при привязке элемента управления к списку
   */
  override fun onBindViewHolder(holder: MeterListViewHolder, position: Int) {
    holder.onBind()
    presenter.onBindViewItem(holder, position)
  }

  /**
   * Колбэк, вызываемый при уничтожении элемента
   */
  override fun onViewRecycled(holder: MeterListViewHolder) {
    super.onViewRecycled(holder)
    holder.onCleanup()
  }

  /**
   * Получить количество элементов в списке
   */
  override fun getItemCount(): Int = presenter.itemsCount
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeterListViewHolder {
    TODO("Not yet implemented")
  }
}