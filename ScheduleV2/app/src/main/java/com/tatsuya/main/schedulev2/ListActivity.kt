package com.tatsuya.main.schedulev2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*
import java.util.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val cal: Calendar = Calendar.getInstance()
        val day:String = cal.get(Calendar.YEAR).toString() + "/" + (cal.get(Calendar.MONTH)+1).toString() + "/" + cal.get(Calendar.DAY_OF_MONTH).toString()
        fab.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            intent.putExtra("day", day)
            startActivity(intent)
        }
    }
}
