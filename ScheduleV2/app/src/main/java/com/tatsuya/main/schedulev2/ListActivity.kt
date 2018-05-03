package com.tatsuya.main.schedulev2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)



        val intent: Intent = Intent(this, MemoActivity::class.java)
        fab.setOnClickListener {
            startActivity(intent)

        }
    }

}
