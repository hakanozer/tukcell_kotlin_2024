fun main() {
    val studentUtil = StudentUtil()

    val student1 = Student("Eray", 101, listOf("Matematik", "Fizik", "Kimya"))
    val student2 = Student("Ahmet", 102, listOf("Tarih", "Coğrafya"))
    val student3 = Student("Veli", 103, listOf("Matematik", "Fizik","Biyoloji", "Kimya"))



    val studentList = listOf(student1, student2, student3)

    for (studentListItem in studentList) {
        studentListItem.listLectures()
        println("==========================================  ")
    }

    val studentWithHighestNumberOfLectures = studentUtil.studentWithHighestNumberOfLectures(studentList)
    if (studentWithHighestNumberOfLectures != null) {
        println("En yüksek ders sayısına sahip öğrenci: ${studentWithHighestNumberOfLectures.name}")
    } else {
        println("Öğrenci bulunamadı.")
    }
}

data class Student(val name: String, val num: Int, val lectures: List<String>) {
    fun listLectures() {
        /// Parametre olarak verilen her ogrenci bilgilerine gore listelenir
        println("$name öğrencisinin aldığı dersler:")
        for (lectureItem in lectures) {
            println(lectureItem)
        }
    }
}

class StudentUtil {
    fun studentWithHighestNumberOfLectures(students: List<Student>): Student? {
        return students.maxByOrNull { it.lectures.size }
    }
}

