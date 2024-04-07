package assignment_two

fun main() {

    // öğrenciler oluşturuldu
    val Ali = Student(studentName = "Ali Bilmem", schoolNumber = 44, lessons = listOf("Matematik","Türkçe"))
    val Erkan = Student(studentName = "Erkan Gülmez", schoolNumber = 21, lessons = listOf("Fen","Müzik","Sosyal"))
    val Zelal = Student(studentName = "Zelal Ölmez", schoolNumber = 57, lessons = listOf("Kotlin","Java","Android"))
    val Sena = Student(studentName = "Sena Sevmez", schoolNumber = 122, lessons = listOf("Matematik"))

    val studentsProcess = StudentsProcess(listOf(Ali,Erkan,Zelal,Sena))

    // Öğrenciye özel olarak aldıgı dersleri listeliyoruz
    Ali.getAllLessons()


    // tüm dersleri öğrenci isimlerine göre yazdırır
    studentsProcess.getAllLessons()

    // en çok ders alan öğrencileri yazdırır ders alan sayısı tüm sınıfta sıfır olabilir o yüzden null kontrölü yapıyoruz
    val studentsMostLessonsList = studentsProcess.findStudentWithMaxLessons()
    if (studentsMostLessonsList.isNotEmpty()){
        for (student in studentsMostLessonsList){
            println(student.studentName)
        }
    }

}