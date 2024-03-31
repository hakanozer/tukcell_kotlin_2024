
/*

Bir liste ve bir set arasındaki farkı döndüren bir fonksiyon yazın. Yani, liste içinde
bulunan ancak sette bulunmayan öğeleri bulun.


*/

fun main() {
    val numberList = listOf<Long>(1,5,7,2,9,66,343)
    val numberSet = setOf<Long>(1,5,7,9,4,1)

    val result = getDifferentOfListFromSet(numberList,numberSet)
    println(result)
}

// bir set ve bir list aldık
fun getDifferentOfListFromSet(list:List<Long>, set:Set<Long>): List<Long>{
    val differentNumbers = mutableListOf<Long>()

    // listedeki her bir elemanı döndürdük
    list.forEach {numList->

        // eğer eleman set içinde yoksa oluşturdugumuz farklı sayılar listesine ekledik
        if (!(set.contains(numList))){
            differentNumbers.add(numList)
        }
    }
    return differentNumbers
}