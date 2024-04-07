package question_2

fun main() {
    // Course Instance
    val math = Course(1, "Math")
    val physics = Course(2, "Physics")
    val businessAndManagement = Course(3, "Business And Management")

    // Student Instance
    val student1 = Student("Omer", 100, listOf(math, physics))
    val student2 = Student("Ali", 101, listOf(math, physics, businessAndManagement))
    val student3 = Student("Veli", 102, listOf(physics))

    // Student Affairs Instance
    val studentAffairs = StudentAffairs(listOf(student1, student2, student3))

    // Print all students info
    studentAffairs.printStudentInfo()
    println()

    // print the student who takes the most courses
    studentAffairs.findTheStudentWhoTakesTheMostCourses()
    println()

    // High School Student Instance
    val highSchoolStudent1 = HighSchoolStudent("Mehmet",100, listOf(math))

    // Reward the high school student
    studentAffairs.rewardTheStudent(highSchoolStudent1)
    println()

    // Reward the student
    studentAffairs.rewardTheStudent(student2)
}