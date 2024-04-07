package soru_2

fun main() {
    val students: List<Student> = listOf(
        OgrenciGrubu1("Ahmet", 1, listOf("Matematik", "Fizik", "Geometri")),
        OgrenciGrubu1("Mehmet", 2, listOf("Matematik Fizik", "Geometri", "Kimya")),
        OgrenciGrubu2("Ayşe", 3, listOf("Biyoloji", "Fizik"))
    )

    students.forEach { it.dersleriListele() }

    val enCokDersliOgrenci = enCokDersalanOgrenci(students)
    if (enCokDersliOgrenci != null) {
        println("En çok dersi olan: ${enCokDersliOgrenci.name}")
    } else {
        println("Veri yok")
    }
}

fun enCokDersalanOgrenci(ogrenciListesi: List<Student>): Student? {
    var enCokDersalanOgrenci: Student? = null
    var maxCourses = Int.MIN_VALUE

    for (student in ogrenciListesi) {
        if (student.lessons.size > maxCourses) {
            enCokDersalanOgrenci = student
            maxCourses = student.lessons.size
        }
    }

    return enCokDersalanOgrenci
}