fun main() {
    val size = wordCounter("I am a software learner")

    println(size)

}

fun wordCounter(words: String): Int {

    //split ile kelimeleri dizi elemanlarına ayır
    val a = words.split(" ")

    //dizi uzunluğu
    return a.size
}