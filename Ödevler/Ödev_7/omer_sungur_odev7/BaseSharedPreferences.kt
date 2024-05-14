package com.omersungur.days8

import android.content.Context
import com.google.gson.Gson

class BaseSharedPreferences(
    context: Context,
) {
    companion object {
        // Hem 2 fonksiyon içinden erişildiği için hem de aynı nesneye sahip olması için singleton + statik yapıldı .
        val gson = Gson()
    }

    private val sharedPreferences =
        context.getSharedPreferences("shared_preferences", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun setUser(key: String, user: User?) {
        with(editor) {
            user?.let {
                val strUser = gson.toJson(it)
                putString(key, strUser)
            }
            // commit yerine apply kullanırsak asenkron çalışır.
            apply()
        }
    }

    fun getUser(key: String): User? {
        val strUser = sharedPreferences.getString(key, null)
        return if (strUser != null) {
            gson.fromJson(strUser, User::class.java)
        } else {
            null
        }
    }
}

/**
 * --- KULLANIMI ---
 *
 * Main Activity:
 * override fun onCreate(savedInstanceState: Bundle?) {
 *     ...
 *
 *     val baseSharedPreferences = BaseSharedPreferences(this)
 *     baseSharedPreferences.setUser("my_key", user) -> user nesnemizi buraya paslıyoruz.
 * }
 *
 * Second Activity:
 * override fun onCreate(savedInstanceState: Bundle?) {
 *     ...
 *
 *     val baseSharedPreferences = BaseSharedPreferences(this)
 *     val user = baseSharedPreferences.getUser("my_key") -> user değişkenimizde artık sakladığımız veriler var.
 * }
 */

/**
 * Sadece User için değil bütün sınıflar için çalışan bir base class örneği istiyorsak:
 */

class BaseSharedPreferences2<T>(
    context: Context,
    private val clazz: Class<T>,
) {
    companion object {
        val gson = Gson()
    }

    // İsim için üstte aldığımız class'ı kullanıyoruz ki birden fazla sınıf kullanımında farklı dosyalar oluşsun.
    private val sharedPreferencesName = "${clazz.simpleName}_shared_preferences"
    private val sharedPreferences =
        context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun setObject(key: String, obj: T?) {
        obj?.let {
            val strObject = gson.toJson(it)
            editor.putString(key, strObject)
        }
        editor.commit()
    }

    fun getObject(key: String): T? {
        val strObject = sharedPreferences.getString(key, null)
        return if (strObject != null) {
            gson.fromJson(strObject, clazz)
        } else {
            null
        }
    }
}

/**
 * --- KULLANIMI ---
 *
 * Main Activity:
 * override fun onCreate(savedInstanceState: Bundle?) {
 *     ...
 *
 *     val baseSharedPreferences = BaseSharedPreferences2(this, User::class.java)
 *     baseSharedPreferences.setObject("my_key", obj) -> obj nesnemizi buraya paslıyoruz.
 * }
 *
 * Second Activity:
 * override fun onCreate(savedInstanceState: Bundle?) {
 *     ...
 *
 *     val baseSharedPreferences = BaseSharedPreferences2(this, User::class.java) -> 2. parametreye gelecek class'ı veriyoruz.
 *     val obj = baseSharedPreferences.getObject("my_key") -> obj değişkenimizde artık sakladığımız veriler var.
 * }
 */
