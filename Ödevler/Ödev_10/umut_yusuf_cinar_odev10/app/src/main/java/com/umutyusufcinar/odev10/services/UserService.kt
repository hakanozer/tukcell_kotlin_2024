//veri tabanı üzerinden hizmet verebilmesi için hizmetlerimizi oluşturuyoruz
//yönetilebilir olması açısından UserService ve NoteService olarak servisleri böldük

package com.umutyusufcinar.odev10.services
import android.content.ContentValues
import android.content.Context
import com.umutyusufcinar.odev10.configs.DB
import com.umutyusufcinar.odev10.models.User

class UserService(context: Context) : DB(context) {
    //kullanıcı ekleme fonksiyon
    fun addUser(user: User): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, user.username)
            put(COLUMN_PASSWORD, user.password)
        }
        val effectRow = db.insert(TABLE_USERS, null, values)
        db.close()
        return effectRow
    }

    //kullanıcının olup olmadığını kontrol eden fonksiyon
    fun getUser(username: String, password: String): User? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_USERS WHERE $COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?", arrayOf(username, password))
        val user = if (cursor.moveToFirst()) {
            User(
                id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID)),
                username = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)),
                password = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD))
            )
        } else {
            null
        }
        cursor.close()
        db.close()
        return user
    }
}