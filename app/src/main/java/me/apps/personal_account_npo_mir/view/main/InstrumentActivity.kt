package me.apps.personal_account_npo_mir.view.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import me.apps.personal_account_npo_mir.presentation.main.InstrumentPresenter
import me.apps.personal_account_npo_mir.view.abstractions.main.IMainView
import me.apps.personal_account_npo_mir.view.main.activities.DiagnosticActivity
import me.apps.personalaccountnpomir.R


private const val NUM_PAGES = 5

class InstrumentActivity : FragmentActivity(),
    IMainView,
    OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrument)

        presenter.onViewCreated(this)

        button = findViewById(R.id.instrumentButton)
        button.setOnClickListener(this)
        button1 = findViewById(R.id.instrumentButton1)
        button1.setOnClickListener(this)
        button2 = findViewById(R.id.instrumentButton2)
        button2.setOnClickListener(this)
        button3 = findViewById(R.id.instrumentButton3)
        button3.setOnClickListener(this)

        adapter = DeviceAdapter(this)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = adapter

        tabLayout = findViewById(R.id.tab_layout)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "${(position + 1)}"
        }.attach()

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem
        }
    }

    private inner class DeviceAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment = InstrumentFragment()
    }

    override fun onClick(view: View?) {
//        presenter.onButtonClick(id)
//        if (view === button) {
//            startAnotherActivity(DiagnosticActivity())
//        }
    }

    override fun setHeader(header: String) {
    }

    override fun refreshItems() {
    }

    override fun startAnotherActivity(activity: Activity) {
        //4 разных старт активити
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        button.setOnClickListener(null)
    }

    private lateinit var button: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var adapter: DeviceAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private var presenter = InstrumentPresenter()

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