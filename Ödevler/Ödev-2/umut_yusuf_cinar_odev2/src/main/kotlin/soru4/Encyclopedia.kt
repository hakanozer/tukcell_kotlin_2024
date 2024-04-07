///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
4. Bir kitap kütüphanesini temsil eden Library adında bir sınıf oluşturun. Bu sınıf,
kütüphanedeki kitapların bir listesini içermeli ve yeni kitapları eklemek ve mevcut
kitapları listelemek için metodlar içermelidir. Ayrıca, belirli bir yazarın kitaplarını
listelemek için bir fonksiyon ekleyin.

Soru Miras alma yapısına daha uygun olması için çeşitlendirin veya uyarlayın demiştiniz hocam.
O sebeple soruyu revize ediyorum:

Bir kitap kütüphanesini temsil eden Library adında bir sınıf oluşturun.
Bu sınıf, kurucu metottan girilen bir writerName isimli String tipinde bir değişken içermeli ve
kütüphanedeki kitapların bir listesini içermeli ve yeni kitapları eklemek ve
mevcut kitapları listelemek için metodlar içermelidir.
Library sınıfından miras alan Encyclopedia adında bir sınıf olmalı.
Bu alt sınıf serialNumber adında Int tipine sahip ve specialBookCover adında ve String tipinde
bir değişken içermeli.
Ayrıca Library sınıfı içerisine, belirli bir yazarın kitaplarını listelemek için bir fonksiyon ekleyin.
 */

package org.example.soru4

class Encyclopedia(name: String, writerNamesOfEncyclopedia: String, var serialNumber: Int, var specialBookCover: String) : Library()