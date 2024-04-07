package soru_3

open class Animal(val isim:String, val tur:String, val yasamAlani:String) {
    override fun toString(): String {
        return "$isim - $tur - $yasamAlani"
    }
}