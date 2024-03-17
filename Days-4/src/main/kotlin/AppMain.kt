import java.util.Random

fun main() {

    val name1 = "Ali"
    val name2 = "ali"

    if (name1 == name2) {
        println("name1 == name2")
    }else {
        println("name1 != name2")
    }

    val result = if (name1 == name2) {
        println("name1 == name2")
        true
    }else {
        println("name1 != name2")
        false
    }
    println(result)

    val num1 = 10
    val num2 = 11
    val end = if (num1 > 9) 20 else 30

    val status = num1 > num2 || num2 > 10
    if (status){ }

    // Else if
    val name = "Ahmet"
    val surname = "Bilmem"
    val email = "ali@mail.com"

    if (name == "") {
        println("name is empty!")
    }else if ( surname == "" ) {
        println("surname is empty!")
    }else if ( email == "" ) {
        println("email is empty!")
    }else {
        println("form send..")
    }

    // When - Swich
    val resultWhen = when (num1) {
        8 -> "Değer 8"
        9 -> "Değer 9"
        10 -> "Değer 10"
        11 -> "Değer 11"
        else -> ""
    }
    println(resultWhen)

    when(num1) {
        8,9,10,11 -> println("8,9,10,11 gibi bir değer")
    }

    when(num1) {
        in 8..11 -> println("8..11 aralığında")
    }

    val obj:Any = Random()
    val item = when(obj) {
        is Int -> "obj Int"
        is String -> "obj String"
        is Random -> "obj Random"
        else -> ""
    }
    println(item)

    for ( i in 20.downTo(1) step 2 ) {
        if (i == 18) {
            continue
        }
        if (i == 8) {
            break
        }
        println(i)
    }

    println("===========================")
    for ( i in 10..1 step 2 ) {
        println(i)
    }


    // while
    val arr = arrayOf("a","b","c","d")
    val iter = arr.iterator()
    while (iter.hasNext()) {
        println(iter.next())
    }

    for(item in iter) {
        println(item)
    }

    do {
        // her durumda en az bir kez çalışan gövdedir.
    }while (iter.hasNext())


    if (!iter.hasNext()) {
        // menüye item ekle
    }else {
        for (item in iter) {
            // menüye item ekle
        }
    }


}