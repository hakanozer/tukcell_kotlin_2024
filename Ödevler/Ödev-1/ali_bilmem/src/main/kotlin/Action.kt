class Action {

    var name = "Erkan"
    val surname = "Bilmem"


    // Fonksyionlar
    // fun
    fun noParams() {
        println("noParams call")
    }

    fun params(userID: Int, token: String) {
        println("$userID - $token")
    }

    fun count(name:String, surname: String) : Int {
        val sum = name + surname
        return sum.count()
    }

    fun fnc1(name:String, age: Int?) : Int {
        var count = name.count()
        age?.let {
            count += it
        }
        return count
    }

    fun fnc1() {
        println("fnc1 Call")
    }

    fun order(a:Double, b: Double, fncAction: (Double, Double) -> Double ) : Double {
        return fncAction(a, b)
    }


}