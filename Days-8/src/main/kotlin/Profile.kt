class Profile {

    var name:String = ""
    var age:Int = 0
    val obj = Action("Ahmet", 100)

    init {
        println("init Call - ${this.name}")
    }

    constructor(){
        println("constructor Empty Call")
    }

    constructor( name: String) {
        this.name = name
        println("constructor name Call")
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
        println("constructor name, age Call")
    }

    fun call() {
        println("${this.name} - ${this.age}")
    }

}