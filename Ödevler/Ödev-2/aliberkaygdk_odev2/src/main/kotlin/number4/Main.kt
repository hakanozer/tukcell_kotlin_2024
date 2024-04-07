package number4

fun main() {
    val kitap1 = Book("Beyaz Diş", "Jack London")
    val library = Library()
    library.ekle(kitap1)
    library.listele()
    library.yazaraGoreListe("Jack London")
}