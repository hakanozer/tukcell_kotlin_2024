fun main(){

    // öğrenciler için object oluşturuyorum
    val student1 = Student("Beyza", 256)
    student1.addCourse("Programlama 1")
    student1.addCourse("Tasarım 2")
    student1.addCourse("Programalam 3")

    val student2 = Student("Aslı", 206)
    student2.addCourse("Programlama 1")
    student2.addCourse("Tasarım 2")
    student2.addCourse("Programalam 3")
    student2.addCourse("Tasarım 4")
    student2.addCourse("Programalam 5")

    val student3 = Student("Zeynep", 291)
    student3.addCourse("Programlama 1")
    student3.addCourse("Tasarım 3")

    // öğrencilerin aldığı dersleri foreach ile listeliyorum
    val students = listOf(student1, student2, student3)
    students.forEach{it.listCourses()}

    // en fazla ders alan öğrenciyi bulacağım ve bilgilerini yazdıracağım
    // maxCourse değişkeni için Student classından maxCourses fonk çağırıyorum ve parametre olarak öğrencileri veriyorum
    val maxCourse = Student.maxCourses(students)
    // maxCourse null değere eşit değilse en fazla ders alan öğrenciyi yazdırır
    if (maxCourse != null) {
        println("\nEn Fazla Ders Alan Öğrenci: ${maxCourse.name} - ${maxCourse.number}")
    }

}