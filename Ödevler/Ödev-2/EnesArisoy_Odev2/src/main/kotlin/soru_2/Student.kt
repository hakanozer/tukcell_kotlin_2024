package org.example.soru_2

/**
 *  Bir öğrenci veritabanını temsil eden Student adında bir sınıf oluşturun. Bu sınıf,
 * öğrencinin adı, numarası ve aldığı derslerin bir listesini içermelidir. Ardından, bir dizi
 * öğrenciyi temsil eden bir liste oluşturun ve bu öğrencilerin derslerini listeleyen bir metod
 * ekleyin. Ayrıca, en yüksek ders sayısına sahip öğrenciyi bulan bir fonksiyon ekleyin.
 */

open class Student(val name: String, val number: Int, val lessons: List<String>) {
    open fun displayLessons() {
        println("$name'nin aldığı dersler:")
        lessons.forEach { println(it) }
    }
}


