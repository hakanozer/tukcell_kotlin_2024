package org.example

fun main() {

    val list= mutableListOf<Int>(1,2,3,4,5,6,7,1,2,3,8)
    val set= mutableSetOf<Int>(1,2,3,4,5,6,7,1,2,3,4,5)

    subtractin(list,set) // Gerekli verileri vererek foksiyon çağırıldı
}

fun subtractin(list:MutableList<Int>,set:MutableSet<Int>):Set<Int>{

    val fark=list.subtract(set) // İki öğe arasındaki farkı bulmaya yarayan fonksiyon, sonuç olarak set döndürür

    return fark
}