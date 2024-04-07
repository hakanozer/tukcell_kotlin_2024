package Soru5

class OnlineShop(val users : MutableList<User>) {

    fun urunEkle(kullaniciID: Int, eklenenUrunler: MutableList<Urun>){
        this.users.forEach { user->
            if(user.id == kullaniciID)
                user.sepet.addAll(eklenenUrunler)

        }
    }

    fun urunCikar(kullaniciID: Int, urun: Urun){
        this.users.forEach { user->
            if(user.id == kullaniciID){
                user.sepet.forEach { myUrun->
                    if (myUrun == urun)
                        user.sepet.remove(myUrun)
                }

            }

        }
    }

    fun sepetiTemizle(kullaniciID: Int){
        this.users.forEach { user->
            if(user.id == kullaniciID){
                user.sepet.clear()
            }

        }
    }

    fun harcamaHesapla(kullaniciID : Int): Int{
    var toplam=0

        this.users.forEach { user->
            if(user.id == kullaniciID){
                user.sepet.forEach {  urun->
                    toplam += urun.urunFiyat
                }
            }

        }
        return toplam
    }

}