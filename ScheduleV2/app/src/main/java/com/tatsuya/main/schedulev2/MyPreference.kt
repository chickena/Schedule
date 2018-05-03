package com.tatsuya.main.schedulev2

import android.content.Context
import com.tatsuya.main.schedulev2.R.id.editText3

class MyPreference(context : Context){

    val PREFERENCE_NAME = "example"

    val preference = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun org(msg:String){
        val editor = preference.edit()
        editor.putString(editText3.toString(), msg)
        editor.apply()
    }

}