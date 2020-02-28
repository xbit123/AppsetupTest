package com.example.appsetuptest

import androidx.fragment.app.Fragment
import com.example.appsetuptest.fragment.FourFragment
import com.example.appsetuptest.fragment.OneFragment
import com.example.appsetuptest.fragment.ThreeFragment
import com.example.appsetuptest.fragment.TwoFragment

enum class MainScreen(val menuItemId: Int, val fragment: Fragment) {
    ONE(R.id.menu_one, OneFragment()),
    TWO(R.id.menu_two, TwoFragment()),
    THREE(R.id.menu_three, ThreeFragment()),
    FOUR(R.id.menu_four, FourFragment())
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}