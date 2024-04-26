package com.example.peekrv.SecondPage

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.peekrv.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val selectedGenre = intent.getStringExtra("selected_genre")
        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tabs)

        val genres = arrayOf("Action", "Comedy", "Drama", "Sci-Fi", "Fantasy", "Sports")
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        val selectedTabIndex = genres.indexOf(selectedGenre)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabTextView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as TextView
            tabTextView.text = genres[position]
            tab.customView = tabTextView
            if (position == selectedTabIndex) {
                tabTextView.background = ContextCompat.getDrawable(this, R.drawable.tab_selected_background)
            } else {
                tabTextView.background = ContextCompat.getDrawable(this, R.drawable.tab_unselected_background)
            }
        }.attach()

//        for (i in 0 until tabLayout.tabCount) {
//            val tab = tabLayout.getTabAt(i)
//            val tabView = tab?.customView as? TextView
//            tabView?.background = ContextCompat.getDrawable(this, R.drawable.tab_unselected_background)
//        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabView = tab.customView as TextView
                tabView.background = ContextCompat.getDrawable(this@MainActivity2, R.drawable.tab_selected_background)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabView = tab.customView as TextView
                tabView.background = ContextCompat.getDrawable(this@MainActivity2, R.drawable.tab_unselected_background)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        // Optional: If there's a specific tab that should be selected based on some condition

        if (selectedTabIndex != -1) {
            viewPager.setCurrentItem(selectedTabIndex, false)

            // Since the smooth scroll is disabled, you may not need to post the selection
            // to the TabLayout's message queue
            tabLayout.getTabAt(selectedTabIndex)?.select()

        }
    }



}