package com.tatsuya.main.schedulev2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_time.*
import java.util.*

class TimeFragment : Fragment() {

    lateinit var parent: TimeActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cal: Calendar = Calendar.getInstance()
        TimeText.text = cal.get(Calendar.HOUR_OF_DAY).toString() + ":" + cal.get(Calendar.MINUTE).toString() + ":" + cal.get(Calendar.SECOND).toString()

        ReturnButton.setOnClickListener { parent.returnmove() }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        parent = context as TimeActivity

    }


}
