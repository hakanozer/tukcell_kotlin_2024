package Soru_4

class LibraryYear: Library() {

    override fun listBooks() {
        println("Kütüphanedeki kitaplar ve yayınlanma yılları: ")
        for (it in books){
            println("${it.name} - ${it.author} - ${it.year}")
        }
    }

    override fun listBooks(author: String) {
        println("$author adlı yazarın kitapları ve yayınlanma yılları: ")
        for (it in books){
            if (it.author == author){
                println("${it.name} - ${it.year}")
            }
        }
    }
}