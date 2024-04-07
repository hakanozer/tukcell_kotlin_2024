package Soru_2

class InternationalStudent: Student {

    var country: String = ""

    constructor(){}

    constructor(name: String, num: Int, courses: List<String>, country: String) {
        this.name = name
        this.num = num
        this.courses.addAll(courses)
        this.country = country
    }

    override fun dersleriListele(list: List<Student>): Map<String, List<String>> {
        val students = mutableMapOf<String, List<String>>()
        for(student in list){
            if(student is InternationalStudent){
                students.put("Uluslararası öğrencinin; Adı: ${student.name} Numarası: ${student.num} Ülkesi: ${student.country} ", student.courses)
            }
        }
        return students
    }
}