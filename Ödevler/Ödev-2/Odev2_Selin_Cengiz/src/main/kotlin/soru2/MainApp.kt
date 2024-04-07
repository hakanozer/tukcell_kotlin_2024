package soru2

fun main() {
    // 2.SORU
    //Student Class
    Student("Selin Cengiz", 567, listOf("Physics", "Math"))
    Student("Zeliha", 323, listOf("Chemistry"))
    Student("Nalan", 327, listOf("Chemistry", "Biology", "Math"))

    println(Student.listLectures()) //Çıktı {Selin Cengiz=[Physics, Math], Zeliha=[Chemistry], Nalan=[Chemistry, Biology, Math]}
    println(Student.highestNumberLecture().name) //Çıktı Nalan
}