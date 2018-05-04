package com.tatsuya.main.schedulev2

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import java.util.*


class DatePick: DialogFragment(), DatePickerDialog.OnDateSetListener{
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year:Int = c.get(Calendar.YEAR)
        val month:Int=c.get(Calendar.MONTH)+1
        val day:Int = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity,this,year,month,day)
    }
}