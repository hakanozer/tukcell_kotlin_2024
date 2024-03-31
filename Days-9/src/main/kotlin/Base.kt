open class Base {

    var code = 0;

    constructor() {
        println("Base Call")
    }

    constructor(count: Int) {
        println("count Call : $count")
    }

    constructor(count: Int, data: String) {
        println("count Call : $count - $data")
    }

    open fun call() {
        action(0);
    }

    fun action( number: Int ): Int {
        return number * number;
    }

}