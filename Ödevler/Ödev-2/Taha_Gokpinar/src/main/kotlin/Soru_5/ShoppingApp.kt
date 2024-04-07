package Soru_5

class ShoppingApp : OnlineShop() {

    override fun toplamHarcama(): Double {
        var toplam = super.toplamHarcama()
        if(toplam > 2000){
            println("Uygulamaya özel 2000₺ üzeri harcamanıza %20 indirim kazandınız.")
            toplam -= 25
            toplam = toplam - (0.2 * toplam)
        }
        else{
            toplam
        }

        return toplam
    }
}