package com.example.appsetuptest

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val screens = arrayListOf<MainScreen>()

    fun setItems(screens: List<MainScreen>) {
        this.screens.apply {
            clear()
            addAll(screens)
            notifyDataSetChanged()
        }
    }

    fun getItems() = screens

    override fun getItem(position: Int) = screens[position].fragment

    override fun getCount() = screens.size
}