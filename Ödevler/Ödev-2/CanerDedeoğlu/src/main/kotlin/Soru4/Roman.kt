package Soru4


class Roman (bookName: String, year: Int, author : String ) : Book(bookName , year , author )
{
    // Tanım
    override fun tanım() {

        println("$bookName romanı , $author tarafından $year yılında yazılmıştır.")
    }
}