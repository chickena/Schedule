package com.tatsuya.main.schedulev2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), RecyclerViewHolder.ItemClickListener {

    lateinit var parent: ListActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListActivity) {
            parent = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val date = arguments!!.getStringArrayList("day")
        val desc = arguments!!.getStringArrayList("desc")
        listRecyclerView.adapter = RecyclerAdapter(parent,this,date,desc)
        listRecyclerView.layoutManager = LinearLayoutManager(parent,LinearLayoutManager.VERTICAL,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fab.setOnClickListener {
            parent.fabPress()
        }
    }

    //cardViewタップした時
    override fun onItemClick(view: View, position: Int) {
        parent.makeToast(position)
    }
}
