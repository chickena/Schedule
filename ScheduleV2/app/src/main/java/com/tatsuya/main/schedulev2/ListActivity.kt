package com.tatsuya.main.schedulev2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class ListActivity : AppCompatActivity() {
    private var dateList:ArrayList<String> = ArrayList()
    private var descList:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val transaction = supportFragmentManager.beginTransaction()
        val listFragment = ListFragment()
        val bundle = Bundle()
        loadData()
        bundle.putStringArrayList("day", dateList)
        bundle.putStringArrayList("desc", descList)

        listFragment.arguments = bundle
        transaction.replace(R.id.listFragmentLayout, listFragment)
        transaction.commit()
    }

    fun fabPress() {
        val cal: Calendar = Calendar.getInstance()
        val day: String = cal.get(Calendar.YEAR).toString() + "/" + (cal.get(Calendar.MONTH) + 1).toString() + "/" + cal.get(Calendar.DAY_OF_MONTH).toString()
        val intent = Intent(this, MemoActivity::class.java)
        intent.putExtra("day", day)
        startActivity(intent)
    }

    fun makeToast(position: Int){
        Toast.makeText(this,"position $position was tapped",Toast.LENGTH_SHORT).show()
    }

    fun loadData(){
        val pref = getSharedPreferences("test", Context.MODE_PRIVATE)
        val map:Map<String,*> = pref.all
        for((key,value) in map){
            dateList.add(key)
            descList.add(value.toString())
        }
    }
}
