fun main() {
    val startValue = 50
    val endValue = 200

    println("Odd numbers in this range: ${createOddNumberArray(startValue, endValue).joinToString()}")
}

fun createOddNumberArray(start : Int, end : Int) : Array<Int>{
    val rangeArray = mutableListOf<Int>()
    for (number in start..end){
        if(number%2 == 1){
            rangeArray.add(number)
        }
    }
    val oddArray = rangeArray.toTypedArray()

    return oddArray
}
