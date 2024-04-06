fun String.call(size: Int): String {
    val a = 10
    return this.lowercase().substring(0, size)
}

fun Action.login( username: String, password: String ) : Boolean {
    if (username == "ali01" && password == "12345") {
        return true
    }
    return false
}