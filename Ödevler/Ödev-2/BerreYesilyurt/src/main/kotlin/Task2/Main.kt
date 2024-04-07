package org.example.Task2

fun main() {

    val student1=Student("Yıldız",210, arrayListOf("Türkçe"))
    val student2=Student("Doğan",210, arrayListOf("Türkçe","Hayat Bilgisi","Edebiyat"))
    val student3=Student("Fazıl",210, arrayListOf("Matematik","Türkçe"))
    val student4=Student("İdil",210, arrayListOf("Hayat Bilgisi","Beden Eğitimi","Müzik","İngilizce"))
    val student5=Student("Gökçen",210, arrayListOf("Türkçe","Matematik","Müzik","Coğrafya","Edebiyat","Fen Bilimleri"))

    val studentsList= mutableListOf<Student>(student1,student2,student3,student4,student5) // Yukarıdaki objelerden Student türünde bir nesne oluştu

    val student=Student("",0, arrayListOf()) // Fonksiyonları çağırabilmek için boş bir nesne oluşturuldu
    student.listLessons(studentsList) // Oluşturulan nesnenin üzerinden fonksiyonlar çağırıldı ve Student'Dan oluşan liste parametresi fonksiyonlara verildi. Öğrenci adlarını ve derslerini listeleme fonksiyonu
    println(student.findTheStudentOfHaveHighestLessons(studentsList)) // En yüksek ders alan öğrenciyi döndürme fonksiyonu

}