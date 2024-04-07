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

// Etçil hayvanları temsil eden Animal alt sınıfını oluşturuyorum.
class Carnivore(name: String, species: String, diet: String, habitat: String) : Animal(name, species, diet, habitat)
