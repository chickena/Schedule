package com.tatsuya.main.schedulev2

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_memo.*


class MemoFragment : Fragment(),DatePickerDialog.OnDateSetListener {
    lateinit var parent: MemoActivity


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MemoActivity) {
            parent = context
        }

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
        Datetext.setText(arguments!!.getString("day"))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Datetext.setOnClickListener {
            val datepicker: DatePick = DatePick()
            datepicker.show(parent.supportFragmentManager, "datePicker")
//            parent.setDate()
        }

        donebutton.setOnClickListener {
            val text: String = editText.text.toString()
            val date: String = Datetext.text.toString()
            if (text != "" && date != "") {
                parent.donePress(date, text)
            } else {
                Toast.makeText(parent, "入力されていません", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val temp = "$year/" + (month + 1) + "/$dayOfMonth"
        Datetext.setText(temp)
    }

    fun dateTextFragSave(temp: String) {
        Datetext.setText(temp)
    }
}
