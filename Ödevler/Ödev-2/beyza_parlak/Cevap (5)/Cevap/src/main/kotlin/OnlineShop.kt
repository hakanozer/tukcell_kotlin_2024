class OnlineShop {
    // kullanıcıların sepetlerini tutmak için mutablemapof kullanıyorum
    // sepetlerindeki ürünleri ise mutableList içinde tutuyorum
    val shoppingCart = mutableMapOf<String, MutableList<String>>()

    // kullanıcının sepetine ürün eklemek için fonk yazıyorum
    fun addToCart(user: String, prouct: String){
        // eğer kullanıcının sepeti varsa ürünü ekliyorum
        if (shoppingCart.containsKey(user)){
            shoppingCart[user]?.add(prouct)
        }else{ // sepeti yoksa bir sepet oluşturuyorum
            shoppingCart[user] = mutableListOf(prouct)
        }
    }

    // kullanıcının sepetini görüntülemek için fonk yazıyorum
    fun displayCart(user: String) {
        val cart = shoppingCart[user]
        // eğer kullanıcının sepeti varsa sepetini yazdırıyorum
        if (cart != null){
            println("$user'in Sepeti:")
            for (item in cart) {
                println("-> $item")
            }
        }else{
            println("$user'in Sepeti: Boş")
        }
        println("----------------------------------------")
    }

    // kullanıcının sepetinden ürün çıkarmak için fonk yazıyorum
    fun removeToProduct(user: String, prouct: String){
        // eğer kullanıcının sepeti varsa ürünü siliyorum
        if (shoppingCart.containsKey(user)){
            shoppingCart[user]?.remove(prouct)
        }else{
            println("$user'in Sepeti Boş Ürün Çıkaramazsınız")
        }

    }

    // kullanıcının sepeti temizlemek için fonk yazıyorum
    fun removeToCart(user: String){
        // eğer kullanıcının sepeti varsa ürünü ekliyorum
        shoppingCart.remove(user)
        println("$user Sepeti Temizlendi")
        println("----------------------------------------")

    }


}