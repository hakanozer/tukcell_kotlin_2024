/// Soru 10


fun main() {
    val list = listOf("Eray", "Altilar", "Ahmet", "Veli" , "Eray" , "Patates","Domates" , "Eray" , "Domates")
    val set = setOf("Eray", "Altilar", "Ahmet", "Veli" )

    val result = differenceBetweenListAndSet(list, set)
    println("Liste ile set arasındaki fark: $result")
}
fun differenceBetweenListAndSet(list: List<String>, set: Set<String>): List<String> {

    return list - set.toList().toSet()

}
