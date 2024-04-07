package soru_2

open class Student(val name: String, val number: Int, val lessons: List<String>) {
    open fun dersleriListele() {
        println("$name dersleri:")
        lessons.forEach { println(it) }
    }
}