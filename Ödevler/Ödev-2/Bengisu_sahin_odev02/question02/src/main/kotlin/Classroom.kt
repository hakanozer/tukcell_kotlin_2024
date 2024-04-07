// The constructor was regarded as appropriate because it said to create a list representing several students.
class Classroom(private val students: Set<Student>) {

    fun listLessons(){
        // Thanks to the "groupBy" function we can group students according to the lesson
        val listOfLessons = students.groupBy { it.lessons }
        // For every lesson, the students were listed using foreach.
        listOfLessons.forEach { (lessons, student) ->
            student.forEach {
                println("${it.name} - ${it.lessons}")
            }
        }
    }

    fun maxLessonStudent(){
        // It was created to find the highest count lesson for a student.
        var maxLesson = 0
        // If there was more than one student who took the most lessons.
        val studentsWithMaxLessons = mutableListOf<Student>()

        //Counts the courses taken by the student
        for (student in students){
            var lessonCount = 0
            for (lesson in student.lessons){
                lessonCount++
                //println("lessonNo $lessonCount")
            }
            // It will find the student who took the most lessons, and then it will add to the list.
            if (lessonCount > maxLesson){
                maxLesson = lessonCount
                studentsWithMaxLessons.add(student)
            } else if (lessonCount == maxLesson) {
                studentsWithMaxLessons.add(student)
            }
            //println(maxLesson)
        }
        // This shows the student who took the most lessons
        if (studentsWithMaxLessons.isNotEmpty()) {
            println("\nThe students with the highest number of lessons and the count of lessons are $maxLesson:")
            studentsWithMaxLessons.forEach { println(it.name) }
        }else{
            println("\nThere is no student with any lessons.")
        }

    }
}