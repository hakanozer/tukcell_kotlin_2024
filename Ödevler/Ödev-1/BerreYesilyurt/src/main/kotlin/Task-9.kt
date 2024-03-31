package org.example

fun main() {

    val dize1="Merhaba dünya"
    val dize2="Java ve kotlin."

    println(mergeLists(dize1,dize2))
}

fun mergeLists(dize1:String,dize2:String):String{
    var dize1_numberOfletter=dize1.count{it.isLetter()} // 1. dizenin harf sayısı, özel bir fonksiyon yardımıyla harf olmayan öğeler eleniyor
    var dize2_numberOfletter=dize2.count{it.isLetter()}  // 2. dizenin harf sayısı

    if(dize2_numberOfletter==dize1_numberOfletter){ // Harf sayıları eşitse 2. dize büyük harfe çevrilerek birleştirilir
        return dize1+dize2.toUpperCase()
    }

    else{ // Değilse iki dize aynı şekilde kalarak birleştirilir
        return dize1+dize2
    }
}