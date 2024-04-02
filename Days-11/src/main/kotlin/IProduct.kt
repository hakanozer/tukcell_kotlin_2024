interface IProduct {

    var name:String

    fun addProduct( product: Product ) : Product
    fun removeProduct( pid: Int ) : Int

    // static
    // uygulamada hiç bir zaman ölmez
    companion object {
         var name:String? = "Serkan"
    }

}