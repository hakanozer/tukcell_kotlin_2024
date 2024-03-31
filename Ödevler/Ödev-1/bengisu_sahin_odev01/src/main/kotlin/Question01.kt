fun main() {

    val array = arrayOf(0,1,2,3,4,5,6,7,8,9,10,11)
    println("\nList containing even numbers: ${addToEvenNumberToList(array)}")

}
fun addToEvenNumberToList(arr: Array<Int>) : List<Int> {
    val evenArray = arr.onEach {
        println("Number - ${it+1} even: ${it % 2 == 0}, because the remainder from 0 : ${it%2}")
    }.filter { it % 2 == 0 }
    return evenArray
}