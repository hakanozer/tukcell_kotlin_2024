fun main() {

    // Mesne üretimi
    // obj -> object, nesne
    // Action -> class, Sınıf
    // Action() -> kurucu method
    val obj:Action = Action()
    val obj2:Any = Action()
    //val obj3:String = Action()
    val obj4 = obj2 as Action
    obj4.name

    // Bir nesne içerisindeki özelliklere (.) operatörü ile erişim sağlanır.
    obj.name = "Serkan"
    println( obj.name )
    println( obj.surname )
    obj.hashCode()


    val obj1 = Action()
    println( obj1.name )

    // Fonksiyon çalıştırma
    val no = obj.noParams()
    obj.noParams()
    obj.noParams()

    obj.params(200, "jwt23423k42k34k23")

    val size = obj.count("Ali", "Bilmem")
    println("Size: $size")
    if ( obj.count("Erkan", "Bil") > 10 ) {
        println("line code")

    }

    obj.fnc1("Ahmet", null)
    obj.fnc1()

    fun senOrder(x: Double, y: Double) = x + y
    val sm = obj.order(10.0, 40.0, ::senOrder)
    println(sm)

    fun senOrderMinus(x: Double, y: Double) = x - y
    val min = obj.order(10.0, 40.0, ::senOrderMinus)
    println(min)


}