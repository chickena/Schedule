package com.tatsuya.main.schedulev2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_memo.*

class MemoActivity : AppCompatActivity() {
    var EXTRA_ITEM_ID = "extra_item_id"

    fun createIntent(context: Context, itemid: Int): Intent {
        val intent = Intent(context, MemoActivity::class.java)
        intent.putExtra(EXTRA_ITEM_ID, itemid)
        return intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        val transaction = supportFragmentManager.beginTransaction()
        val memoFragment = MemoFragment()

        transaction.replace(R.id.memoFragmentLayout, memoFragment)
        transaction.commit()
    }

    fun donemove() {

        val mypreference = MyPreference(this)




        finish()
    }

    fun toastman() {
        Toast.makeText(this, "${intent.extras.get("key1")}", Toast.LENGTH_LONG).show()
        val aaa = intent.extras.get("key1")
        val intent: Intent = getIntent()
    }
}
