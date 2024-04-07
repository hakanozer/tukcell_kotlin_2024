package question_3

class Lion : Animal {
    constructor(name: String, species: String, habitat: String) : super(name, species, habitat){
    }

    override fun sound() {
        println("ROAR")
    }
}