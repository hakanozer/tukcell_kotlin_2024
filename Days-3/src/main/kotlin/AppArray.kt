fun main() {

    // Dizi -> Birden fazla değişken değerinin bir arada tutulduğu değişkenlerdir.
    val names = "Ali"

    // <String> -> generic type
    var users = arrayOf<String>("Mehmet", "Ahmet", "Ahmet", "Ali", "Zehra", "Zehra", "Ayşe")

    // index -> dizinin içindeki n. elemanı işaret eder ve "0" dan başlar.
    println(users[2])
    val data = users[0]

    // Dizi içindeki toplam eleman sayısı
    println(users.count())

    // Set -> dizi içindeki üyelerin değerlerirnin değiştirilmesini sağlar
    users.set(0, "Kemal")
    users[1] = "Ömer"
    println(users[0])
    println(users[1])

    println("===========================")
    // loop
    for (item in users) {
        println(item)
    }

    println("===========================")
    val dataString = "Merhaba Kotlin";
    for (item in dataString) {
        println(item)
    }

    println("===========================")
    for (i in 0..users.size - 1 step 2) {
        println(users[i])
    }

    if ("Ali" in users) {
        println("Ali Succsess")
    }
    println("===========================")
    for (item in users) {
        println(item)
    }
    println("=========================== iter -1")
    // iterator
    val iter = users.iterator()
    iter.forEach {
        println(it)
    }
    println("=========================== iter -2")
    iter.forEach{
        println(it)
    }

    // Benzersiz değerlere sahip olmak
    println("===========================")
    var newUsers = users.distinct()
    for(item in newUsers) {
        println(item)
    }
    
}