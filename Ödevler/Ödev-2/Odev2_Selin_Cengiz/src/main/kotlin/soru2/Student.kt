package soru2

class Student(val name: String, val number: Long, val lectures: List<String>) {

    companion object {
        private val listStudent = mutableListOf<Student>()

        // Student isimleri ve aldığı dersler ile map oluşturulup, her öğrencinin aldığı dersler listelenir.
        fun listLectures() =
            listStudent.associateBy({ it.name }, { it.lectures })

        //MaxBy fonksiyonu ile liste içerisindeki derslerin sayısı max olan student döndürülür.
        fun highestNumberLecture() =
            listStudent.maxBy { it.lectures.size }

    }

    //Student nesnesi oluşturulduğunda otomatik olarak listeye ekleme yapar.
    init {
        listStudent.add(this)
    }


}