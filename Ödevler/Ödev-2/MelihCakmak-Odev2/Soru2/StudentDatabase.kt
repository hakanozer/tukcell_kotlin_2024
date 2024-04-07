package Soru2

class StudentDatabase {
    private val studentList= mutableListOf<Student>()




    fun addStudent(student: Student) {
        studentList.add(student)
    }
    fun removeStudent(student: Student){
        studentList.remove(student)
    }

    fun printStudents(){
        println("------Students------")

        studentList.forEach {
            println("Student Name : ${it.name}\nStudent Number : ${it.number}\nCourses : ${it.courses}\n")

        }
        println("---------------------")

    }

    fun studentMostCourses(): Student? {
        if (studentList.isNotEmpty()){

            var student=studentList.first()
            studentList.forEach { student_temp ->
                if (student_temp.courses.size>student.courses.size){
                    student=student_temp
                }



            }
            return student
        }
        println("Henüz Öğrenci Eklenmemiş")
        return null

    }

    fun addCoursetoStudent(student: Student,course:String){
        student.courses.add(course)

    }
}