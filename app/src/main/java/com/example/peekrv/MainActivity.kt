package com.example.peekrv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ItemsAdapter(this)
        val recyclerView: RecyclerView = findViewById(R.id.rvItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val widthDp = resources.displayMetrics.widthPixels

        recyclerView.setPaddingRelative(
            /* start = */ resources.getDimensionPixelSize(R.dimen._20dp),
            /* top = */ resources.getDimensionPixelSize(R.dimen._10sdp),
            /* end = */ (widthDp * 0.2).roundToInt(),
            /* bottom = */ 0
        )

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }
}