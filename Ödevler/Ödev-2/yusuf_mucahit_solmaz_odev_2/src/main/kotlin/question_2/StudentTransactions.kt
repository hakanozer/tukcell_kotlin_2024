package question_2

abstract class StudentTransactions {

    abstract fun getLessonsByStudentNu(studentNu:Long) : Array<Course>?

    abstract fun getStudentByHighestLessonNumber(): Student?

    abstract fun addStudent(student: Student)
}