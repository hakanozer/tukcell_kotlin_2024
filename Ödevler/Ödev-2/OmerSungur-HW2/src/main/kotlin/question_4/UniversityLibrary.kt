package question_4

// UniversityLibrary extends Library
class UniversityLibrary(
    private val bookList: List<Book>,
    private val collageStudentList: List<CollageStudent>
) : Library(bookList) {
    fun rewardStudentsOfTheMonth(studentOfTheMonth: CollageStudent) {
        println("${studentOfTheMonth.studentName}, the student of the month, was given 2 extra books as gifts")
    }
}