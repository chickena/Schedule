package com.tatsuya.main.schedulev2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_memo.*

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

        Toast.makeText(this, "${intent.extras.get("key1")}", Toast.LENGTH_LONG).show()
        val aaa = intent.extras.get("key1")
//        val intent: Intent = getIntent()
//        val aaa = intent.getStringExtra("key1")

        donebutton.setOnClickListener {
//            startActivityForResult(intent,555)で遷移した場合
//            val intent = Intent(this,MainActivity::class.java)
//            intent.putExtra("key2","value2")
//            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}