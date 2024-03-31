fun main() {

    val a = A(25)
    val b = B()
    val c = C()

    poliCall(a)
    poliCall(b)
    poliCall(c)
}

fun poliCall( base: Base ) {
    if ( base is A ) {
        base.print(100);
    }
    base.call()
}