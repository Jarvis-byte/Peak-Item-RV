package com.example.peekrv.SecondPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peekrv.R
import com.google.android.material.imageview.ShapeableImageView

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to your views
        if (position == 0) {
            holder.imgView.setImageResource(R.drawable.img)
            holder.textView.text = "1"
        }
        if (position == 1) {
            holder.imgView.setImageResource(R.drawable.img2)
            holder.textView.text = "2"
        }
        if (position == 2) {
            holder.imgView.setImageResource(R.drawable.img3)
            holder.textView.text = "3"
        }
        if (position == 3) {
            holder.imgView.setImageResource(R.drawable.img4)
            holder.textView.text = "4"
        }
        if (position == 4) {
            holder.imgView.setImageResource(R.drawable.img5)
            holder.textView.text = "5"
        }
        if (position == 5) {
            holder.imgView.setImageResource(R.drawable.img6)
            holder.textView.text = "6"
        }

    }

    override fun getItemCount(): Int = 6  // Number of items in RecyclerView

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize your views here
        val imgView: ShapeableImageView = itemView.findViewById(R.id.ivContentImage)
        val textView: TextView = itemView.findViewById(R.id.tvNumber1)
    }
}