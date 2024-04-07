///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
2. Bir öğrenci veri tabanını temsil eden Student adında bir sınıf oluşturun. Bu sınıf,
öğrencinin adı, numarası ve aldığı derslerin bir listesini içermelidir. Ardından, bir dizi
öğrenciyi temsil eden bir liste oluşturun ve bu öğrencilerin derslerini listeleyen bir metod
ekleyin. Ayrıca, en yüksek ders sayısına sahip öğrenciyi bulan bir fonksiyon ekleyin.

Soru Miras alma yapısına daha uygun olması için çeşitlendirin veya uyarlayın demiştiniz hocam
O sebeple soruya şöyle bir kısım daha ekliyorum:

Ardından Student sınıfını miras alan GeniusStudent adında bir sınıf oluşturun.
En yüksek ders sayısına sahip olan öğrencileri bulan fonksiyonun bulduğu öğrenciler
bu sınıfa dahil olsun ve yıl sonu 15000 TL burs kazansınlar.
 */

package org.example.soru2

//Sınıftan miras alınabilmesi için open ile niteliyorum.
open class Student(val name: String, val sirName: String, val number: Int, val courses: List<String>) {
    fun displayTakenCourses() {
        for (course in courses) {
            println("- $course")
        }
    }
}