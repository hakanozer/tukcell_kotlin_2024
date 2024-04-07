///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
3. Bir hayvanat bahçesindeki hayvanları temsil eden Animal adında bir sınıf oluşturun. Bu
sınıf, hayvanın adı, türü ve yaşam alanı gibi özellikleri içermelidir. Daha sonra, bir Zoo
sınıfı oluşturun ve bu sınıf, bir hayvanat bahçesinde bulunan hayvanların bir listesini
saklamalıdır. Ayrıca, belirli bir yaşam alanına sahip hayvanları listelemek için bir metod
ekleyin

Soru Miras alma yapısına daha uygun olması için çeşitlendirin veya uyarlayın demiştiniz hocam.
O sebeple soruyu revize ediyorum:

Bir hayvanat bahçesindeki hayvanları temsil eden Animal adında bir sınıf oluşturun.
Bu sınıf, hayvanın adı, türü, beslenme şekli ve yaşam alanı gibi özellikleri içermelidir.
Hayvanlar beslenme şekillerine göre alt sınıflara bölünmeli yani Animal sınıfından miras almalıdır.
Daha sonra, bir Zoo  sınıfı oluşturun ve bu sınıf,
bir hayvanat bahçesinde bulunan hayvanların bir listesini saklamalıdır.
Ayrıca, belirli bir yaşam alanına sahip hayvanları listelemek için bir metod ekleyin.
Bu metod suda etçil hayvanları listelemek için olsun.
 */

package org.example.soru3

//Hayvanat bahçesini temsil eden Zoo sınıfını oluşturuyorum.
class Zoo(private val animals: List<Animal>) {
    //Bu soruda istenen yaşam alanlarına göre listelemeyi sağlayan metot, oluşturuyorum.
    fun listAnimalsInHabitat(habitat: String) {
        println("$habitat yaşam alanına sahip hayvanlar:")
        animals.filter { it.habitat == habitat }.forEach { it.displayInfo() }
    }

    //Revize ettiğim senaryoda etçil hayvanları listelemek için benim eklediğim metod, oluşturuyorum.
    fun listAnimalsByDiet(diet: String) {
        println("$diet beslenme şekline sahip hayvanlar:")
        animals.filter { it.diet == diet }.forEach { it.displayInfo() }
    }
}