fun main() {
    val array = arrayOf("Bengisu","Sahin","Akdeniz","Antalya","aaa")
    println(calculateNumberCount(array))
}

fun calculateNumberCount(arr: Array<String>) : Map<Char, Int>{
    val countMap = mutableMapOf<Char, Int>()
    for (string in arr) {
        for (char in string) {
            val charLower = char.lowercaseChar()
            val count = countMap.getOrDefault(charLower, 0)
            countMap[charLower] = count + 1
        }
    }
    return countMap
}
