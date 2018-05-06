package com.tatsuya.main.schedulev2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class RecyclerAdapter(private val context: Context, private val itemClickListener: RecyclerViewHolder.ItemClickListener, private val itemList1: List<String>,private val itemList2: List<String>) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder ?. let {
            it.textViewDate.text = itemList1.get(position)
            it.textViewDesc.text = itemList2.get(position)
//            it.textViewRating.text = itemList.get(position)
//            it.textViewPrice.text = itemList.get(position)
            it.itemImageView.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun getItemCount(): Int {
        return itemList1.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.layout_list,parent,false    )

        mView.setOnClickListener{view ->
            mRecyclerView?.let{
                itemClickListener.onItemClick(view,it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(mView)
    }


}