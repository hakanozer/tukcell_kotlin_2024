fun main() {
    val student = Student("Bengisu", 52, setOf("Kotlin", "Android", "Unity", "C#", "C#"))
    val student2 = Student("Süleyman", 53, setOf("Laravel", "Intellij"))
    val student3 = Student("Aybars", 54, setOf("Kotlin", "C#", "Unity"))

    val classroom = Classroom(mutableSetOf(student,student2,student3))
    classroom.listLessons()
    classroom.maxLessonStudent()
}