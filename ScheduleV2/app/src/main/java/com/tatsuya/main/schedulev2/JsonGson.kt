package com.tatsuya.main.schedulev2

import android.content.SharedPreferences
import com.google.gson.Gson

class JsonGson{
    //    Json形式に変換してファイルに保存する拡張関数
    fun SharedPreferences.applytoJson(key: String, value: Any) {
        edit().putString(key, Gson().toJson(value)).apply()
    }

    //    ファイルのJson形式の値を変換する拡張関数
    fun <T : Any> SharedPreferences.getFromJson(key: String, clazz: Class<T>): T {
        return Gson().fromJson(getString(key, ""), clazz)
    }
}