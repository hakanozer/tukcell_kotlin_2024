package Soru2

fun main() {


    val ogrenci1 = Student(25, "Osman", 200290, mutableListOf("Matematik"))
    ogrenci1.addCouse("Fizik")

    val ogrenci2 = Student(18, "Ahmet", 200295, mutableListOf("Kimya"))
    ogrenci2.addCouse("Biyoloji")
    ogrenci2.addCouse("Cografya")

    Student.allStudentList()
    Student.listStudentsWithMaxCourses()



    val ogretmen1 = Instructor(35,"Candan",245678, mutableListOf("Matematik"))
    ogretmen1.addEgitim("Matematik 2")

    val ogretmen2 = Instructor(27, "Bekir", 12345, mutableListOf("Kimya"))
    ogretmen2.addEgitim("Biyoloji")
    ogretmen2.addEgitim("Cografya")

    Instructor.listAllInstructorandCourse()
    Instructor.listInstructorsWithMaxCourses()



}