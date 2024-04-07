///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
5. Bir online alışveriş uygulamasını temsil eden OnlineShop adında bir sınıf oluşturun. Bu
sınıf, kullanıcıların sepetlerini ve sepetlerindeki ürünleri içermelidir. Sepete ürün
eklemek, çıkarmak ve sepeti temizlemek için metodlar ekleyin. Ayrıca, kullanıcıların
toplam harcamalarını hesaplamak için bir fonksiyon ekleyin.

Soru Miras alma yapısına daha uygun olması için çeşitlendirin veya uyarlayın demiştiniz hocam.
O sebeple soruyu revize ediyorum:

Bir online alışveriş uygulamasını temsil eden OnlineShop adında bir sınıf oluşturun. Bu
sınıf, kullanıcıların sepetlerini ve sepetlerindeki ürünleri içermelidir. Sepete ürün
eklemek, çıkarmak ve sepeti temizlemek için metotlar ekleyin. Ayrıca, kullanıcıların
toplam harcamalarını hesaplamak için bir fonksiyon ekleyin.
Miras ile OnlineShop kısmından OnlineSalerUmut ve OnlineSalerYusuf adındaki iki adet alt sınıf oluşturulsun ve
bu alt sınıflar toplam harcama için üst sınıfta oluşturduğumuz metodu
"miras yoluyla polimorfizm" ile kullanıp override etsinler.
 */

package org.example.soru5
//sadece alt sınıflar erişebilsin diye product tanımlıyorum
class Product(val name: String, val price: Double) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false
        return name == other.name && price == other.price
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + price.hashCode()
        return result
    }

    override fun toString(): String {
        return "Product(name='$name', price=$price)"
    }
}
