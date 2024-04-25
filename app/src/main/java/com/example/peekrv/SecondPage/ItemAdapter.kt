package com.example.peekrv.SecondPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peekrv.R

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to your views
    }

    override fun getItemCount(): Int = 6  // Number of items in RecyclerView

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize your views here
    }
}