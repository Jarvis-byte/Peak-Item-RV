package com.example.peekrv.FirstPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peekrv.R

class ItemsAdapter() : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    private var orientation: Int? = null


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        orientation = (recyclerView.layoutManager as LinearLayoutManager).orientation
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView =
            view.findViewById(R.id.tvTitle1) // assuming you're using the same ID

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_top_10_shows_all_genre, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return 10
    }

}
