package com.tatsuya.main.sharedpreferences_json

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
//supportV4のFragmentはSupportFragmentリネイムしてます
import android.support.v4.app.Fragment as SupportFragment

//GSONを使ったSharedPreferencesの拡張関数
public fun SharedPreferences.applyToJson(key: String, value: Any) {
    edit().putString(key, Gson().toJson(value)).apply()
}

public fun <T : Any> SharedPreferences.getFromJson(key: String, clazz: Class<T>): T {
    return Gson().fromJson(getString(key, ""), clazz)
}

//ActivityやらFragmentの拡張関数
public fun Activity.bindSharedPreference(name: String)
        : ReadOnlyProperty<Activity, SharedPreferences> = required(name, prefInitializer)

public fun Fragment.bindSharedPreference(name: String)
        : ReadOnlyProperty<Fragment, SharedPreferences> = required(name, prefInitializer)

public fun SupportFragment.bindSharedPreference(name:String)
        : ReadOnlyProperty<SupportFragment, SharedPreferences> = required(name,prefInitializer)

//SharedPreferencesを生成する拡張プロパティ
//Stringを受け取ってSharedPreferencesを返す関数リテラルが帰る
private val Activity.prefInitializer: Activity.(String) -> SharedPreferences
    get() = { getSharedPreferences(it, Context.MODE_PRIVATE) }

private val Fragment.prefInitializer: Fragment.(String) -> SharedPreferences
    get() = { activity.getSharedPreferences(it, Context.MODE_PRIVATE) }

private val SupportFragment.prefInitializer: SupportFragment.(String) -> SharedPreferences
    get() = { activity!!.getSharedPreferences(it, Context.MODE_PRIVATE) }

//nameにSharedPreferencesのファイル名、initializerにStringを受け取ってSharedPreferencesを返す関数リテラル。結果SharedDelegateが帰る
private fun <T> required(name: String, initializer: T.(String) -> SharedPreferences)
        = SharedDelegate (name,initializer)

//自作のDelegateクラス。valueがnullの場合、コンストラクターで受け取った
//ファイル名とprefInitializerでSharedPreferencesを生成します
private class SharedDelegate<T>(private val name: String, val initializer: T.(String) -> SharedPreferences) : ReadOnlyProperty<T, SharedPreferences> {
    private var value: SharedPreferences? = null

    override fun getValue(thisRef: T, property: KProperty<*>): SharedPreferences {
        if (value == null) {
            value = thisRef.initializer(name)
        }
        return value as SharedPreferences
    }
}
