fun main() {
    //bir dizi girişi
    val charArray = arrayOf('j', 'c', 'c', 'a', 'x', 'a', 'a')

    //method çağırımı
    repeatingCharSearcher(charArray)



}

//kullanıcıdan dizi isteyen, bu diziyi dolaşıp kaç kez tekrarlandığını hesaplayan method
fun repeatingCharSearcher(array: Array<Char>): Map<Char, Int> {
    val rMap = mutableMapOf<Char, Int>()

    // bu döngü alınan diziyi dolaşır,
    // getOrDefault ile harfler daha önce mape key olarak girilmediyse(yani harflerle ilk karşılaşma durumu)
    // başta değer olmadığı içi 0 +1 olur
    // eğer index değeri deha önce mapte key olarak bulunuyorsa
    // o key değerine +1 eklenir ve sayma işlemi görmüş olur
    for (index in array) {
        rMap[index] = rMap.getOrDefault(index, 0) + 1
    }

    //map listeleme
    for (index in rMap) {
        println("${index.key} : ${index.value} times")
    }
    return rMap
}


