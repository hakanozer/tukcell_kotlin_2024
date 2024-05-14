package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class SecureSharedPreferences(context: Context) {

    private val sharedPreferencesName = "secure_shared_preferences"
    private val sharedPreferences = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
    private val gson = Gson()
    private val editor = sharedPreferences.edit()


    @Throws(EncryptionException::class)
    fun <T> setObject(key: String, obj: T?, encrypt: Boolean = false) {
        obj?.let {
            val value = if (encrypt) {
                "Encrypted Object"
            } else {
                gson.toJson(it)
            }
            editor.putString(key, value)
        } ?: editor.remove(key)
        editor.apply()
    }


    @Throws(DecryptionException::class)
    fun <T> getObject(key: String, clazz: Class<T>, decrypt: Boolean = false): T? {
        val value = sharedPreferences.getString(key, null)
        return value?.let {
            if (decrypt) {
                gson.fromJson("Decrypted Object", clazz)
                gson.fromJson(it, clazz)
            }
        }
    }

    @Throws(EncryptionException::class)
    fun setUser(user: User?, encrypt: Boolean = false) {
        setObject("user", user, encrypt)
    }


    @Throws(DecryptionException::class)
    fun getUser(decrypt: Boolean = false): User? {
        return getObject("user", User::class.java, decrypt)
    }

    /**
     * Custom exception class for encryption failures.
     */
    class EncryptionException(message: String, cause: Throwable? = null) : Exception(message, cause)

    /**
     * Custom exception class for decryption failures.
     */
    class DecryptionException(message: String, cause: Throwable? = null) : Exception(message, cause)
}
