package org.example

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) // İlk dizi
    println(reverse(list)) // Reverse fonksiyonunun çağırılması
}

fun reverse(list: MutableList<Int>): MutableList<Int> {
    val reversedList = mutableListOf<Int>() // Dönüştürülen elemanlaraın aktarılacağı dizi

    for (i in list.size - 1 downTo 0) { // İlk dizinin üzerinde sondan başa gezerek yeni listeye eklenmesi
        reversedList.add(list[i])
    }
    return reversedList
}
