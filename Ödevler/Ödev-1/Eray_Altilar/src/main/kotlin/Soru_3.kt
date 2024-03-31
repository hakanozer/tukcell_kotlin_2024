/// Soru 3
import java.util.*
fun main() {
    val names = listOf("Eray", "Altilar", "Ahmet", "Veli" )

    val reversedList = reverseElements(names)

    println("Reversed list: $reversedList")
}
fun reverseElements(list: List<String>): List<String> {
    val reversedList = mutableListOf<String>()

    for (item in list) {
        ///once listedeki elemanlarin hepsini kucuk harf olarak aliyoruz
        val lowerCaseName = item.lowercase(Locale.getDefault())
        /// daha sonra reversed fonksyionu ile ceviriyoruz ve bir listeye ekliyoruz
        val reversedElement = lowerCaseName.reversed()
        reversedList.add(reversedElement)
    }

    return reversedList
}
