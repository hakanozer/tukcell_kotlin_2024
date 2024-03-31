/// Soru 6
fun main() {
    /// Kullanicinin bu degeri girdiğini varsayalim
    val inputValue = 50
    val primeNumList = primeNumberFinder(inputValue)
    println("1 ile $inputValue arasındaki asal sayılar: $primeNumList")
}

fun primeNumberFinder(inputValue: Int): List<Int> {
    val primeNums = mutableListOf<Int>()

    for (num in 2..inputValue) {
        var isPrime = true
        for (i in 2 until num) {
            /// Eger sayi asal degilse isPrime degerini false yaparak ilk for dongusune geri donuyoruz
            if (num % i == 0) {
                isPrime = false
                break
            }
        } /// inner for end
        if (isPrime) {
            primeNums.add(num)
        }
    }

    return primeNums
}
