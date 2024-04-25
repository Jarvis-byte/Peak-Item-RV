package com.example.peekrv.SecondPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.peekrv.MyViewModel
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

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = genres[position]
        }.attach()

        // Set the selected tab based on the genre received from MainActivity
        val tabIndex = genres.indexOfFirst { it == selectedGenre }
        if (tabIndex != -1) {
            viewPager.currentItem = tabIndex
        }

    }

}