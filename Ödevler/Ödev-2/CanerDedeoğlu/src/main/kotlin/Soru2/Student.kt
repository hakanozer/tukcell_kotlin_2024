package Soru2
class Student( age: Int, Name :String, val studentId:Int, val courses: MutableList<String>) : Person(age, Name ) {

    companion object
    {
        //Bütün öğrencileri tutacak liste
        private val allStudent = mutableListOf<Student>()

        // Yeni öğrenci ekleme
        fun addStudent ( student: Student)
        {
            allStudent.add(student)

        }
        // Öğrenicileri - derslerini listeleme
        fun allStudentList ()
        {
            allStudent.forEach { student ->
                println("${student.Name} aldığı dersler : ${student.courses.joinToString()}")
            }
        }

        // En fazla dersi alan öğrenciyi bulma
        fun listStudentsWithMaxCourses() {
            if (allStudent.isEmpty()) {
                println("Öğrenci listesi boş.")
                return
            }

            // En çok kursa sahip öğrencinin kurs sayısını bul
            val maxCourses = allStudent.maxOf { it.courses.size }

            // En çok kursa sahip olan tüm öğrencileri bul ve yazdır
            val studentsWithMaxCourses = allStudent.filter { it.courses.size == maxCourses }

            println("En çok derse sahip olan öğrenciler:")
            studentsWithMaxCourses.forEach { student ->
                println("${student.Name} - ${student.courses.size} kurs")
            }
        }


    }

    init {
        addStudent(this)
    }

    // Öğrenciye ders ekleme
    fun addCouse (couseName : String )
    {
        courses.add(couseName)
        println("$Name isimli öğrenci $couseName dersine kaydoldu.")
    }


}