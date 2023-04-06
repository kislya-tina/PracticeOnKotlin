package me.apps.personal_account_npo_mir.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class DeviceAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = InstrumentFragment()
        fragment.arguments = Bundle().apply{
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }

}