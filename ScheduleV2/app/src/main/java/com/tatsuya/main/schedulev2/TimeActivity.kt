package com.tatsuya.main.schedulev2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.activity_time.*
import kotlinx.android.synthetic.main.fragment_time.*
import java.util.*

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)
        val transaction = supportFragmentManager.beginTransaction()
        val timeFragment = TimeFragment()

        transaction.replace(R.id.timeFragmentLayout, timeFragment)
        transaction.commit()


    }

    fun returnmove() {
        finish()
    }

}
