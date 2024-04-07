package assignment_two

open class Student{

    // veriler oluşturuldu
    var studentName =""
    var schoolNumber:Int=0
    var lessons:List<String> = emptyList()

    constructor(){

    }

    // primary constructordan gelen veriler üstteki değerlerimize atandı
    constructor(
        studentName:String,
        schoolNumber:Int,
        lessons: List<String>
    ){
        this.studentName = studentName
        this.schoolNumber = schoolNumber
        this.lessons = lessons
    }

    open fun getAllLessons(){
        for (lesson in lessons){
            println(lesson)
        }
    }




}