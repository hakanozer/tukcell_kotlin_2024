package Soru2

class Instructor(age: Int, Name: String, val persId: Int, val courseEgitim : MutableList<String> ) : Person(age, Name) {

    companion object
    {
       private val allInstructor = mutableListOf<Instructor>()

        // Yeni öğretmen ekleme
        fun addInstructor (ınstructor : Instructor)
        {
            allInstructor.add(ınstructor)
        }
        // Öğretmenleri ve dersleri listeleme
        fun listAllInstructorandCourse()
        {
            allInstructor.forEach { ınstructor ->
                println("${ınstructor.Name} , Verdiği dersler : ${ınstructor.courseEgitim}")

            }
        }

        // En fazla ders alan öğretmen bulma
        fun listInstructorsWithMaxCourses() {
            if (allInstructor.isEmpty()) {
                println("Öğrenci listesi boş.")
                return
            }

            // En çok derse sahip öğretmenin ders sayısını bulma
            val maxCourses = allInstructor.maxOf { it.courseEgitim.size }

            // En çok derse sahip olan tüm öğretmeni bul
            val studentsWithMaxCourses = allInstructor.filter { it.courseEgitim.size == maxCourses }

            println("En çok derse sahip olan öğretmenler:")
            studentsWithMaxCourses.forEach { student ->
                println("${student.Name} - ${student.courseEgitim.size} kurs")
            }
        }
    }

    init {

        addInstructor(this)
    }

    // Ders ekleme
    fun addEgitim(egitim:String)
    {
        courseEgitim.add(egitim)
        println("$Name isimli hocamız $egitim dersini vermeye başladı.")
    }



}