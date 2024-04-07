class Student(val name: String, val number: Int) {
    // courses için MutableList oluşturuyorum
    val courses: MutableList<String> = mutableListOf()

    // course adlarını eklemek için fonksiyon oluşturuyorum
    fun addCourse(courseName: String){
        // add metodu ile ekliyorum
        courses.add(courseName)
    }

    // kursları listelemek için fonk oluşturuyorum
    fun listCourses(){
        println("$name adlı öğrencinin aldığı dersler: ")
        // kursları listelemek için foreach ile listenin içini geziyorum
        courses.forEach{
            println(it)
        }
    }

    // maximum kurs sayısını bulmak için fonk oluşturuyorum
    // dönüşünde her öğrencinin aldığı ders sayısına göre max değeri döndürmek için maxByOrNull fonksiyonunu kullanıyorum
    // companion object: bir sınıf içindeki statik elemanların tutulduğu yapıdır. companion object sınıfın bir örneğine özgü değil, sınıfa özgü olan elemanları barındırır
    companion object{
        fun maxCourses(student: List<Student>): Student?{
            return student.maxByOrNull {
                it.courses.size
            }
        }
    }
}