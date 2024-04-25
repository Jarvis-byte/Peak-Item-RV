package com.example.peekrv.FirstPage

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.peekrv.R
import com.example.peekrv.SecondPage.MainActivity2
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var genreTagsTextView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genreTagsTextView = findViewById(R.id.genreTags)
        genreTagsTextView.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("selected_genre", genreTagsTextView.text.toString())
            startActivity(intent)
        }
        val adapter = ItemsAdapter()
        recyclerView = findViewById(R.id.rvItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val widthDp = resources.displayMetrics.widthPixels

        genreTagsTextView.setPadding(
            resources.getDimensionPixelSize(R.dimen._20dp), 0, resources.getDimensionPixelSize(
                R.dimen._20dp
            ), 0
        )

        recyclerView.setPaddingRelative(
            /* start = */ resources.getDimensionPixelSize(R.dimen._20dp),
            /* top = */ resources.getDimensionPixelSize(R.dimen._10sdp),
            /* end = */ (widthDp * 0.2).roundToInt(),
            /* bottom = */ 0
        )


        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
// Initially set the text for the first item.
        updateTextBasedOnPosition()
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    updateTextBasedOnPosition()
                }
            }
        })

        // Set the initial text specifically for the first item.
        genreTagsTextView.text = "Action"


    }

    private fun updateTextBasedOnPosition() {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val centerPosition =
            layoutManager.findFirstVisibleItemPosition() + (layoutManager.findLastVisibleItemPosition() - layoutManager.findFirstVisibleItemPosition()) / 2
        when (centerPosition) {
            0 -> {
                genreTagsTextView.text = "Action"


            }

            1 -> {
                genreTagsTextView.text = "Comedy"

            }

            2 -> {
                genreTagsTextView.text = "Drama"

            }

            3 -> {
                genreTagsTextView.text = "Sci-Fi"

            }

            4 -> {
                genreTagsTextView.text = "Fantasy"

            }

            5 -> {
                genreTagsTextView.text = "Sports"

            }

            else -> {
                genreTagsTextView.text = "Genre for  ${centerPosition + 1}"

            }
        }
    }
}