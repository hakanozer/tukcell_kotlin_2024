class B : Base {

    constructor() {
        code = 30
    }

    override fun call() {
        val end = action(20)
        println("B End: $end")
    }

    fun x() {
       println("x call")
    }


}