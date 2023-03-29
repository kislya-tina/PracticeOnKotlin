package me.apps.personal_account_npo_mir.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.apps.personalaccountnpomir.R

class InstrumentActivity : FragmentActivity(),
    OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrument)

        button = findViewById(R.id.instrumentButton)
        button.setOnClickListener(this)

        adapter = DeviceAdapter(this)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator (tabLayout, viewPager){ tab, position ->
            tab.text = "${(position + 1)}"
        }.attach()
    }

    override fun onClick(p0: View?) {
    }


    override fun onDestroy() {
        super.onDestroy()
        button.setOnClickListener(null)
    }
    private lateinit var button : Button
    private lateinit var adapter : DeviceAdapter
    private lateinit var viewPager : ViewPager2
    private lateinit var tabLayout : TabLayout

}
/*
    instrument activity
        каждый метод по циклу, с презентером работать
    presenter for ia, fragments in pager
        должна быть логика oncreFrag
        countFrag
    abstractions for ia, fragment, pager


    реализовать сам пейджер с листанием
    элементами пейджера будут фрагменты
    на них
    принимающие параметры и отобразить параметры(номер (Page #N))
*/
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