fun main() {
    val str = "Bengi"
    val str2 = "Sahin"

    println(concatenateTwoString(str, str2))

    val str3 = "Bengi"
    val str4 = "Su"

    println(concatenateTwoString(str3, str4))
}

fun concatenateTwoString(string: String, string2: String) : String{

    //The most efficient approach in terms of memory because +/plus() creates new String objects.
    val concatenatedStr: String = if (string.length == string2.length){
        "$string$string2".uppercase()
    }else{
        "$string$string2"
    }

    return concatenatedStr
}
