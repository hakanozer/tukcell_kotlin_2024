package soru4

fun main() {

    //Book Class
    Book("Hunter x Hunter", "Yoshihiro Togashi", "Manga")
    Book("Divine Comedy", "Dante", "Poetry")
    Book("Soul Land", "Tang Jia San Shao", "Manga")

    //Library Class
    println(Library.getAllBook()) //Çıktı [Name:Hunter x Hunter, Author:Yoshihiro Togashi, Type:Manga, Name:Divine Comedy, Author:Dante, Type:Poetry, Name:Soul Land, Author:Tang Jia San Shao, Type:Manga]
    println(Library.filteredBook("Yoshihiro Togashi")) //Çıktı [Name:Hunter x Hunter, Author:Yoshihiro Togashi, Type:Manga]

}