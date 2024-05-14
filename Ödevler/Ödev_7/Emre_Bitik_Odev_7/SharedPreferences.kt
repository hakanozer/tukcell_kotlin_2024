import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
class SharedPreferences(context: Context) {
         val sharedPreferences: SharedPreferences = context.getSharedPreferences("customer", Context.MODE_PRIVATE)

    fun getUser(): User?{
        val userJson = sharedPreferences.getString("user", null)
        return if (userJson != null) Gson().fromJson(userJson, User::class.java) else null
    }
    fun setUser(user: User){
            val editor = sharedPreferences.edit()
            editor.putString("user", Gson().toJson(user))
            editor.apply()
    }


    }

