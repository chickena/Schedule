package com.tatsuya.main.schedulev2

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.DatePicker
import android.widget.Toast
import com.google.gson.Gson

class MemoActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    var temp = ""
//    var EXTRA_ITEM_ID = "extra_item_id"

//    fun createIntent(context: Context, itemid: Int): Intent {
//        val intent = Intent(context, MemoActivity::class.java)
//        intent.putExtra(EXTRA_ITEM_ID, itemid)
//        return intent
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        val intent: Intent = getIntent()
        temp = intent.extras.get("day").toString()

        val transaction = supportFragmentManager.beginTransaction()
        val memoFragment = MemoFragment()

        transaction.replace(R.id.memoFragmentLayout, memoFragment)
        transaction.commit()
    }

    fun donemove(key: String, value: String) {
        val pref = getSharedPreferences("test", Context.MODE_PRIVATE)
//        Jsonの場合
//        val memo = Memo()
//        memo.value = value
//        pref.applytoJson(key,memo)
//        val fromj = pref.getFromJson(key,memo::class.java)
        val editor: SharedPreferences.Editor = pref.edit()
        editor
                .putString(key, value)
                .apply()
        finish()
    }

    fun toastman() {
//        Toast.makeText(this, "${intent.extras.get("key1")}", Toast.LENGTH_LONG).show()
//        val aaa = intent.extras.get("key1")
//        val intent: Intent = getIntent()
    }

    fun errortoast() {
        Toast.makeText(this, "入力されていません", Toast.LENGTH_LONG).show()
    }

    fun setDate() {
        val datepicker: DatePick = DatePick()
        datepicker.show(supportFragmentManager, "datePicker")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        temp = "$year/" + (month + 1) + "/$dayOfMonth"
    }

    fun SharedPreferences.applytoJson(key: String, value: Any) {
        edit().putString(key, Gson().toJson(value)).apply()
    }

    fun <T : Any> SharedPreferences.getFromJson(key: String, clazz: Class<T>): T {
        return Gson().fromJson(getString(key, ""), clazz)
    }
}

//class Memo{
//    lateinit var value: String
//}
