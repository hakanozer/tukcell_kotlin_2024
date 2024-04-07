package question_2

class StudentAffairs(private val studentList: List<Student>) {
    fun printStudentInfo() {
        studentList.forEach { student ->
            println(
                "${student.studentName} takes: ${
                    student.courseList.joinToString { course ->
                        course.courseTitle
                    }
                }"
            )
        }
    }

    fun findTheStudentWhoTakesTheMostCourses() {
        val studentWhoTakesTheMostCourses = studentList.maxByOrNull { student ->
            student.courseList.size
        }
        println(
            "${studentWhoTakesTheMostCourses?.studentName} has ${studentWhoTakesTheMostCourses?.courseList?.size} " +
                    "and courses: ${studentWhoTakesTheMostCourses?.courseList?.joinToString { it.courseTitle }}"
        )
    }

    fun rewardTheStudent(student: Student) {
        if (student is HighSchoolStudent) {
            println("${student.studentName} is a high school student. He/She was given an algebra book this month")
        } else {
            println("${student.studentName} is a student. He/She was given the book this month")
        }
    }
}