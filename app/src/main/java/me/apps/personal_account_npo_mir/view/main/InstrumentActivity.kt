package me.apps.personal_account_npo_mir.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.apps.personalaccountnpomir.R

class InstrumentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_reg)
    }
}

/*
class MainActivity :
  AppCompatActivity(),
  IMainView {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    //Ищем RecyclerView в разметке
    recyclerView = findViewById<RecyclerView?>(R.id.main_meters_recycler_view)
      .apply {
        //Устанавливаем ему адаптер
        adapter = this@MainActivity.adapter
      }
    presenter.onViewCreated(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override fun setHeader(header: String) {
    supportActionBar?.title = header
  }

  @SuppressLint("NotifyDataSetChanged")
  override fun refreshItems() {
    adapter.notifyDataSetChanged()
  }

  private lateinit var recyclerView: RecyclerView
  private val presenter = MainPresenter()
  private val adapter = MetersRowAdapter(presenter)

}
 */