package com.tatsuya.main.schedulev2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_memo.*

import android.util.Log
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences.Editor
import android.content.Context.MODE_PRIVATE





class MemoFragment : Fragment() {

    lateinit var parent:MemoActivity



    override fun onAttach(context: Context?) {
        super.onAttach(context)
        parent = context as MemoActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parent.toastman()
<<<<<<< HEAD
=======



>>>>>>> 8637bea69b0f463086825837ff6921efe5de5848
        donebutton.setOnClickListener {



            parent.donemove()
        }
    }
}
