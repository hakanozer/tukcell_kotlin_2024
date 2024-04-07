package number3

fun main() {
    val marti = Kus("Martı", "Kara")
    val hamsi = Balik("Hamsi", "Deniz")

    val zoo =Zoo(mutableListOf(marti,hamsi))

    zoo.alanaGoreListe("Deniz")
}