
fun main() {
    // Öğrenci listesi oluşturma
    val student = listOf(
        Student("Ahmet", 101, listOf("Anayasa", "Hukuk", "İngilizce","Medeni Hukuk")),
        Student("Ayşe", 102, listOf("Anayasa", "Türk Dili")),
        Student("Mehmet", 103, listOf("Anayasa", "İdare Hukuku", "Türk Hukuku","")),
        Student("Burak", 104, listOf("Anayasa", "Hukuk", "İngilizce","Medeni Hukuk","Anayasa Yargısı","İdare Hukuku")),

    )

    // Her öğrencinin aldığı dersleri listeleme
    student.forEach { it.displayCourses() }

    // En fazla ders alan öğrenciyi bulma
    val studentWMostCourses = findWMostCourses(student)
    if (studentWMostCourses != null) {
        println("\n${studentWMostCourses.name} isimli en çok ders alan öğrencidir.")
    } else {
        println("\nÖğrenci Bulunamadı.")
    }
}
