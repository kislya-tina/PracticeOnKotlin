package me.apps.personal_account_npo_mir.view.main.instruments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.apps.personal_account_npo_mir.di.App
import me.apps.personal_account_npo_mir.presentation.main.instruments.InstrumentPresenter

class DeviceAdapter(fragment: FragmentActivity, val presenter : InstrumentPresenter) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = App.metersService.meters.size

    override fun createFragment(position: Int): Fragment {
        val fragment = InstrumentFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position)
        }
        return fragment
    }
}