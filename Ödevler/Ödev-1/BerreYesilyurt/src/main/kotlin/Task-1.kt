package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val array=arrayOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15) // Fonksiyona parametre olarak verilen dizi

    println(findEvenNumbers(array))
}

fun findEvenNumbers(array:Array<Int>):List<Int>{ // Aldığı dizideki çift sayıları filtreler ve geriye bir liste döndürür
    val list=array.filter {
        it%2==0
    }
    return list;
}