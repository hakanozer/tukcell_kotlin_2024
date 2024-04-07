package soru_3

fun main() {
    val zoo = Zoo()

    val inek = Animal("İnek", "Memeli", "Kara")
    val balik = Animal("Balık", "Balık", "Su")
    val timsah = Animal("Timsah", "Sürüngen", "Kara ve Su")

    zoo.hayvanEkle(inek)
    zoo.hayvanEkle(balik)
    zoo.hayvanEkle(timsah)

    zoo.yasamAlaninaGoreHayvanlar("Kara")
}