package com.aliberkaygedikoglu.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedP(context: Context) {

    private val sharedP: SharedPreferences =
        context.getSharedPreferences("myPref", Context.MODE_PRIVATE)


    fun setUser(user: User) {
        val editor = sharedP.edit()
        editor.putString("user_name", user.name)
        editor.putInt("user_id", user.id)

        editor.apply()
    }

    fun getUser(): User {
        val userName = sharedP.getString("user_name", "") ?: ""
        val userAge = sharedP.getInt("user_id", 0)

        return User(userName, userAge)
    }


}

data class User(val name: String, val id: Int)