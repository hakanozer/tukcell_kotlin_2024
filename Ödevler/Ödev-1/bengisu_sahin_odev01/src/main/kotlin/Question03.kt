fun main() {
    val strlist = mutableListOf<Any>("Bengisu","Sahin","Akdeniz","Antalya","aaa")
    val intList = mutableListOf<Any>(4,5,25,86,378)
    val charList = mutableListOf<Any>('s',"n","d","t","a")

    println("Reversed list: ${reverseElements(intList)}")
    println("Reversed list without reversed() function: ${secondOption(intList)}")
}

fun reverseElements(list: MutableList<Any>) : MutableList<Any>{
    val reversedList = mutableListOf<Any>()
    for (index in (0..<list.size).reversed()){
        reversedList.add(list[index])
    }
    return reversedList
}

// Without reversed() function
fun secondOption(list: MutableList<Any>) : MutableList<Any>{
    val reversedList = mutableListOf<Any>()
    for (index in list.size -1 downTo 0){
        reversedList.add(list[index])
    }
    return reversedList
}
