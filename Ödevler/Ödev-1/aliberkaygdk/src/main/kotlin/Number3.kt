fun main() {
    val list = listOf("ali", 'x', 1, 10.5f)

    val reversed = reverser(list)
    println(reversed)

}

//liste ters çevirme için bir method bulunuyormuş
//özellikle liste elemanlarının hangi türde olacağı belirtilmediğinden Any cinsi yazdım
fun reverser(list: List<Any>): List<Any> {

    return list.reversed()
}