class A : Base {

    constructor() : super(100) {
        println("A Call")
        code = 20
    }

    constructor(num: Int) : super(num) {
        println("A Call - $num")
    }

    override fun call() {
        val end = action(10)
        println("A End: $end")
    }

    fun print(size: Int) {
        if (size > 10) {
            call();
        }else {
            super.call();
        }
    }

}