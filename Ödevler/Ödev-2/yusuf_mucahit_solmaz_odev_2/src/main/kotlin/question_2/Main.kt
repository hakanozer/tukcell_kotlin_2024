package question_2

fun main() {

    val courses = listOf(
        Course("Math", 4.5),
        Course("Science", 3.0),
        Course("History", 4.0),
        Course("Literature", 6.0),
        Course("Physics", 3.0),
        Course("Chemistry", 4.0),
        Course("Biology", 3.0)
    )

    val students = listOf(
        Student("Ali", 151346, arrayOf(courses[3], courses[6], courses[5])),
        Student("Ayşe", 151347, arrayOf(courses[0], courses[1])),
        Student("Fatma", 151348, arrayOf(courses[2], courses[4])),
        Student("Mehmet", 151349, arrayOf(courses[1], courses[3], courses[5])),
        Student("Zeynep", 151350, arrayOf(courses[0], courses[2], courses[4], courses[6], courses[3])),
        Student("Mustafa", 151351, arrayOf(courses[1], courses[3], courses[5], courses[6])),
        Student("Gülsüm", 151352, arrayOf(courses[0], courses[2], courses[4]))
    )

    val transaction = StudentTransactionImp()

    for (student in students) {
        transaction.addStudent(student)
    }

    val studentLessons = transaction.getLessonsByStudentNu(151349)

    studentLessons?.forEach {
            lesson ->
        println("Course: ${lesson.courseName} Credit: ${lesson.courseCredit}")
    }

    /*
    Output:

    Course: Science Credit: 3.0
    Course: Literature Credit: 6.0
    Course: Chemistry Credit: 4.0
    */


    val studentWithMostCourses = transaction.getStudentByHighestLessonNumber()

    println("Student with the Most Courses: ${studentWithMostCourses!!.studentName} Nu: ${studentWithMostCourses.studentNu}")

    /*
    Output:

    Student with the Most Courses: Zeynep Nu: 151350
    */
}
