fun main() {

    val a = vowel("ali")
    println(a)

}

fun vowel(string: String): Int {

    var counter = 0


    for (index in string) {
        if (index == 'a' || index == 'e' || index == 'i' || index == 'o' || index == 'u') {
            counter++
        }

    }

    return counter
}