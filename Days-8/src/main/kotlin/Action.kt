class Action (val name: String, val age: Int) {

    init {
        //println("init call")
        call()
    }


    fun call() {
        println("$name - $age")
    }




}