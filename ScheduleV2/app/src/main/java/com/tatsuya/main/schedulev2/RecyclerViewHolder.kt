package com.tatsuya.main.schedulev2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val textViewDate: TextView = view.findViewById(R.id.textViewDate)
    val textViewDesc: TextView = view.findViewById(R.id.textViewDesc)
//    val textViewRating: TextView = view.findViewById(R.id.textViewRating)
//    val textViewPrice: TextView = view.findViewById(R.id.textViewPrice)
    val itemImageView: ImageView = view.findViewById(R.id.itemImageView)

    init {
        // layoutの初期設定するときはココ
    }
}