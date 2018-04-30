package com.tatsuya.main.schedulev2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.CalendarView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), CalendarView.OnDateChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cal: Calendar = Calendar.getInstance()
        calendarView.setOnDateChangeListener(this)

        val intent: Intent = Intent(this, MemoActivity::class.java)
        addbutton.setOnClickListener { startActivity(intent) }
    }

    override fun onSelectedDayChange(view: CalendarView?, year: Int, month: Int, dayOfMonth: Int) {
    }
}
