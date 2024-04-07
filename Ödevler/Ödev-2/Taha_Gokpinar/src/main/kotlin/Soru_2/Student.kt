package Soru_2

open class Student {

    var name = ""
    var num = 0
    var courses = mutableListOf<String>()

    constructor(){

    }

    constructor(name: String, num: Int, courses: List<String>){
        this.name = name
        this.num = num
        this.courses.addAll(courses)
    }

    open fun dersleriListele(list: List<Student>): Map<String,List<String>>{
        val students =  mutableMapOf<String,List<String>>()
        for(student in list){
            students.put("Öğrencinin; Adı: ${student.name} Numarası: ${student.num} ", student.courses)
        }
        return students
    }

    fun enFazlaDerseSahipOgrenci(students: List<Student>): Student? {
        var student = Student()
        var enCokDers = 0

        for(it in students){
            if(it.courses.size > enCokDers){
                enCokDers = it.courses.size
                student = it
            }
        }
        return student
    }
}