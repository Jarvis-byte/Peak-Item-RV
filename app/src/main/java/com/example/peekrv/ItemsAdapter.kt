package com.example.peekrv

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val context: Context) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    private var orientation: Int? = null


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        orientation = (recyclerView.layoutManager as LinearLayoutManager).orientation
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView =
            view.findViewById(R.id.tvTitle1) // assuming you're using the same ID
        // Add other view bindings if necessary
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_top_10_shows_all_genre, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        if (orientation != LinearLayout.VERTICAL) {
//            holder.itemView.layoutParams = (holder.itemView.layoutParams as RecyclerView.LayoutParams).apply {
//                val displayMetrics = DisplayMetrics()
//                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
//                // To show the edge of the next/previous card on the screen, we'll adjust the width of our MATCH_PARENT card to make
//                // it just slightly smaller than the screen. That way, no matter the size of the screen, the card will fill most of
//                // it and show a hint of the next cards.
//                val widthSubtraction = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40f, displayMetrics).toInt()
//                width = displayMetrics.widthPixels - widthSubtraction
//                // We always want the spot card centered. But the RecyclerView will left-align the first card and right-align the
//                // last card, since there's no card peeking on that size. We'll adjust the margins in those two places to pad it out
//                // so those cards appear centered.
//                // Theoretically we SHOULD be able to just use half of the amount we shrank the card by, but for some reason that's
//                // not quite right, so I'm adding a fudge factor developed via trial and error to make it look better.
//                val fudgeFactor = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60f, displayMetrics).toInt()
//                val endAdjustment = (widthSubtraction / 2) - fudgeFactor
//                marginStart = if (position == 0) endAdjustment else 0
//                marginEnd = if (position == (itemCount - 1)) endAdjustment else 0
//            }
//        }
    }

    override fun getItemCount(): Int {
        return 10
    }

}
