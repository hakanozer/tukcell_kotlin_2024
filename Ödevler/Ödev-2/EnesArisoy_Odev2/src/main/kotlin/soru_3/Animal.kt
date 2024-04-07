package org.example.soru_3

/**
 *  Bir hayvanat bahçesindeki hayvanları temsil eden Animal adında bir sınıf oluşturun. Bu
 * sınıf, hayvanın adı, türü ve yaşam alanı gibi özellikleri içermelidir. Daha sonra, bir Zoo
 * sınıfı oluşturun ve bu sınıf, bir hayvanat bahçesinde bulunan hayvanların bir listesini
 * saklamalıdır. Ayrıca, belirli bir yaşam alanına sahip hayvanları listelemek için bir metod
 * ekleyin.
 */

open class Animal(val name: String, val habitat: String) {
    open fun getInfo(): String {
        return "Adı: $name, Yaşam Alanı: $habitat"
    }
}