package com.tatsuya.main.schedulev2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_time.*
import java.util.*

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)
        val backint: Intent = Intent(this, MainActivity::class.java)
        ReturnButton.setOnClickListener {
            startActivity(backint)
        }

        val cal : Calendar = Calendar.getInstance()

        TimeText.text = cal.get(Calendar.HOUR_OF_DAY).toString() + ":" + cal.get(Calendar.MINUTE).toString() + ":" + cal.get(Calendar.SECOND).toString()


    }
}
