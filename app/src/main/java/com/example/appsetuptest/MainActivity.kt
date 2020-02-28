package com.example.appsetuptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var navigationView: BottomNavigationView
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Toast.makeText(this, "Fab pressed", Toast.LENGTH_SHORT).show()
        }

        navigationView = findViewById(R.id.bottom_navigation)
        viewPager = findViewById(R.id.vp_main)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.setItems(arrayListOf(MainScreen.ONE, MainScreen.TWO, MainScreen.THREE, MainScreen.FOUR))

        val defaultScreen = MainScreen.ONE
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        navigationView.setOnNavigationItemSelectedListener(this)

        viewPager.adapter = viewPagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val selectedScreen = viewPagerAdapter.getItems()[position]
                selectBottomNavigationViewMenuItem(selectedScreen.menuItemId)
            }
        })
    }

    fun scrollToScreen(mainScreen: MainScreen) {
        val screenPosition = viewPagerAdapter.getItems().indexOf(mainScreen)
        if (screenPosition != viewPager.currentItem) {
            viewPager.currentItem = screenPosition
        }
    }

    private fun selectBottomNavigationViewMenuItem(menuItemId: Int) {
        navigationView.setOnNavigationItemSelectedListener(null)
        navigationView.selectedItemId = menuItemId
        navigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        getMainScreenForMenuItem(item.itemId)?.let {
            scrollToScreen(it)
            return true
        }
        return false
    }
}
