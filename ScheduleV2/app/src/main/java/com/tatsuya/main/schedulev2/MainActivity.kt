package com.tatsuya.main.schedulev2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

// , CalendarView.OnDateChangeListener
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        val calFragment = CalFragment()

        transaction.replace(R.id.calFragmentLayout, calFragment)
        transaction.commit()
//        val cal: Calendar = Calendar.getInstance()
//        calendarView.setOnDateChangeListener(this)
//        textView2.text = cal.get(Calendar.YEAR).toString() + "年" + cal.get(Calendar.MONTH).toString() + "月" + cal.get(Calendar.DAY_OF_MONTH).toString() + "日"
//
//        val addintent: Intent = Intent(this, MemoActivity::class.java)
//        val listintent: Intent = Intent(this, ListActivity::class.java)
//        addbutton.setOnClickListener { startActivity(addintent) }
//        listbutton.setOnClickListener { startActivity(listintent) }
    }

    fun addmove() {
        val intent = Intent(this, MemoActivity::class.java)
        intent.putExtra("key1", "value1")
        startActivity(intent)
    }

//    startActivityForResult(intent,555)の場合
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 555 && resultCode == Activity.RESULT_OK){
//            val received = data!!
//            Toast.makeText(this,"${received.extras.get("key2")}",Toast.LENGTH_LONG).show()
//        }
//    }

    fun listmove() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    fun timemove() {
        val intent = Intent(this, TimeActivity::class.java)
        startActivity(intent)
    }

//    override fun onSelectedDayChange(view: CalendarView?, year: Int, month: Int, dayOfMonth: Int) {
//        textView2.text = year.toString() + "年" + month.toString() + "月" + dayOfMonth.toString() + "日"
//    }
}
