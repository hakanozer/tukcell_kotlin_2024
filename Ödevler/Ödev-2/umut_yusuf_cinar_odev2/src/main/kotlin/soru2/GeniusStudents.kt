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

//Bu sınıf miras alan sınıf, özgünlük olarak öğrencilere burs verme yeteneğine sahip
class GeniusStudents(name: String, sirName: String, number: Int, courses: List<String>) : Student(name, sirName, number, courses) {
    val isStudentHasScholarship = true
    //En yüksek ders sayısına sahip olan öğrencileri bulan bir nesne oluşturuyorum.
    //Bir sınıf içinde bulunan ve o sınıfın bir örneği olmadan çağrılabilen bir nesne olması için
    //Derste bahsettiğiniz gibi bir compainon object oluşturuyorum hocam.
    companion object {
        fun findGeniusStudents(students: List<Student>): List<GeniusStudents> {
            //burada listeler için tanımlanabilen yardımcı bir fonksiyon kullandım.
            val maxCourses = students.maxOfOrNull { it.courses.size } ?: return emptyList()

            //Gerekli filitrelemeyi yapıp en yüksek ders sayısına sahip olan öğrencileri
            //GeniusStudent sınıfının nesnelerine dçnüştürüyorum.
            return students.filter { it.courses.size == maxCourses }.map {
                GeniusStudents(it.name, it.sirName, it.number, it.courses)
            }
        }
    }
    //Burs kazanan öğrencilere burs veren metodu ekliyorum
    fun awardScholarship() {
        if (isStudentHasScholarship) {
            println("$name $sirName adlı öğrenci yıl sonu 15000 TL burs kazandı.")
        }
    }
}