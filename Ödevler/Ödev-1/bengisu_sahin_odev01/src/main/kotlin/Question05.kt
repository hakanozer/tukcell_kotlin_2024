fun main() {
    val array = arrayOf("Bengisu","Sahin","Akdeniz","Antalya","aaa")

    println("The number of vowels in a given string: ${calculateNumberOfVowels(array)}")
}

fun calculateNumberOfVowels(arr: Array<String>) : Int{
    val vowels = listOf('a','e','i','o','u')
    var count = 0

    for (string in arr) {
        for (char in string.lowercase()) {
            if (char in vowels){
                count ++
            }
        }
    }
    return count
}
