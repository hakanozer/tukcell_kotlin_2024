package org.example.Task2

class Student(val name:String,val no:Int,val lessons:ArrayList<String>) { // Ad, numara ve öğrencinin aldığı derslerden oluşn bir sınıf

    fun listLessons(list:MutableList<Student>):Map<String,ArrayList<String>>{ // Aldığı öğrenci listesiyle, öğrencinin adını ve aldığı dersleri döndürüyor
        val map= mutableMapOf<String,ArrayList<String>>() // Öğnrecinnin adı ve aldığı dersler burada tutulur

        list.forEach {
            if(it.name.isNotEmpty()){ // Eğer elemanın ismi boş değilse, o öğrencinin adı ve dersleri haritaya eklenebilir
                map.put(it.name,it.lessons)
        }
        }

        //println(map)
        return map; // Sonuç olarak öğrenciyi ve aldığı dersleri döner
    }

    fun findTheStudentOfHaveHighestLessons(list:MutableList<Student>):String{ // En çok ders alan öğrenciyi bulan fonksiyon
        var maxLessons:Int=0 // İlk başta en yüksek dersi tutn parametre 0'dır
        var theStudentOfHaveHighestLessons="" // En yüksek dersi alan öğrenci başta boştur

        list.forEach {
            if(it.lessons.size>maxLessons){ // Eğer öğrencinin aldığı dersler dizisinin boyutu, yukarıda tanımlanan değişkenden büyükse, en büyük ders değeri güncellenir
                maxLessons=it.lessons.size
                theStudentOfHaveHighestLessons=it.name // En büyük derse sahip olan objenin içerisindeki öğrenci ismi de öğrenci adını tutan değişkene atanır
            }
        }

        return "En yüksek ders sayısına sahip öğrenci : "+theStudentOfHaveHighestLessons // Geriye en yüksek ders alan öğrenciyi döndürür

    }




}