fun main() {
    val list = listOf(1,2,3,4,4,5)
    val set = setOf(3,4,5,5,6)

    println(differencesBtwListAndSet(list, set))
}

fun differencesBtwListAndSet(list: List<Any>, set: Set<Any>) : List<Any>{
    val difList = mutableListOf<Any>()

    for (obj in list){
        if (!set.contains(obj)){
            difList.add(obj)
        }
    }

    return difList
}
