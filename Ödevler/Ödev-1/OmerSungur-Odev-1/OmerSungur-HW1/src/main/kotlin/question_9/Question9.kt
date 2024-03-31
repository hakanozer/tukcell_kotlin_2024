package question_9

fun main() {
    val string1 = "Hello, how are you today?"
    val string2 = "Hello, what is your name?"

    println(mergeString(string1, string2))
}

/**
 * mergeString function takes two parameters which type are String. These parameters represent user input.
 * This function returns String, and this value represents the concatenation of two string expressions.
 * mergedString variable represents result of concatenated string
 * If two string parameters length are equal then the result should be uppercase.
 */
fun mergeString(string1: String, string2: String): String {
    var mergedString = ""

    mergedString += string1
    mergedString += string2

    if (string1.length == string2.length) {
        mergedString = mergedString.uppercase()
    }
    return mergedString
}

