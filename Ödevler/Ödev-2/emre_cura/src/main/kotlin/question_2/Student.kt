package question_2

class Student {
    var name = ""
    var id = 0
    var listOfCourses = mutableListOf<Course>()


    constructor(id: Int, name: String, listOfCourses: MutableList<Course>){
        this.id =  id
        this.name = name
        this.listOfCourses = listOfCourses
    }
    fun lectures(students: List<Student>) {
        students.forEach {student ->
            println("Id: ${student.id}, Name: ${student.name}, Courses : ${student.listOfCourses}")

        }
    }
    fun mostNumberOfCourse(students: List<Student>) {
        var student = students.get(0)
        students.forEach {
            if (it.listOfCourses.size > student.listOfCourses.size){
                student = it
            }
        }
        println("Student with the most courses: ${student.name}, Number of course : ${student.listOfCourses.size}")
    }

}