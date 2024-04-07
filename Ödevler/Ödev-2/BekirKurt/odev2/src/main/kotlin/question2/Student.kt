class Student(val name: String, val number: Int, val lessons: List<String>) {
   
    fun listCourses() {
        println("\n$name's lessons:")
        lessons.forEach { println(it) }
    }
}