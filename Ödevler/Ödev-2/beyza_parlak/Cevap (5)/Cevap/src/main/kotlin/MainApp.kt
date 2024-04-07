fun main(){

    // OnlineShop sınıfından bir object oluşturuyorum
    val shop = OnlineShop()

    // kullanıcıların sepetlerine ürünler ekliyorum
    shop.addToCart("user-1", "Keyboard 12s")
    shop.addToCart("user-1", "Phone 11s")
    shop.addToCart("user-1", "Logitech Mouse 3")
    shop.addToCart("user-2", "Phone 11s")
    shop.addToCart("user-2", "Asus Laptop 10S11")
    shop.addToCart("user-2", "MSI Laptop 59631H")
    shop.addToCart("user-2", "Asus Keyboard Series X")
    shop.addToCart("user-3", "Asus Keyboard Series Y")
    shop.addToCart("user-3", "Asus Keyboard Series Z")

    // kullanıcıların sepetlerini görüntüleyin
    shop.displayCart("user-1")
    shop.displayCart("user-2")
    shop.displayCart("user-3")

    // kullanıcıların sepetinden ürün çıkarıyorum
    shop.removeToProduct("user-1", "Phone 11s")
    shop.removeToProduct("user-2", "Asus Laptop 10S11")
    shop.removeToProduct("user-4", "Keyboard")
    // user-3 ün sepeti boş olduğu için ürün çıkaramazsınız çıktısını göreceğim

    // kullanıcının sepetini temizliyorum
    shop.removeToCart("user-3")

}