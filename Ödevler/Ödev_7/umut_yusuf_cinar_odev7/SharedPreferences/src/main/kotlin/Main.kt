package org.example

import android.content.Context
import com.google.gson.Gson

//base class oluşturuyorum
class BaseClassForSharedPreferences(
    context: Context,
) {
    //statikmiş gibi bir davranış göstermesi için companion objesi oluşturacağım
    companion object {
        val gson = Gson()
    }
    //getShared ile alıyorum
    private val sharedPreferences = context.getSharedPreferences("for_sp", Context.MODE_PRIVATE)
    private val editorForSp = sharedPreferences.edit()

    //metotları yazmaya başlıyorum
    fun setSharedPreferencesForOnlyUser(key: String, user: User?) {
        with(editorForSp) {
            //let kullanarak kontrollü bir kod yazıyorum
            user?.let {
                val stringUser = gson.toJson(it)
                putString(key, stringUser)
            }
            apply()
        }
    }

    //yine null kontrol detayı bu noktada önemli
    fun getSharedPreferencesForOnlyUser(key: String): User? {
        val stringUser = sharedPreferences.getString(key, null)
        return if (stringUser != null) {
            gson.fromJson(stringUser, User::class.java)
        } else {
            null
        }
    }
}



