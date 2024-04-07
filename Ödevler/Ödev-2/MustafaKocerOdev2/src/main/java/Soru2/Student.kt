package Soru2

class Student(var name :String, var no : Int, val dersler : MutableList<String>) {


    fun ogrencilerinDersleriniListele(ogrenciListesi : MutableList<Student>){

        ogrenciListesi.forEach { ogrenci->
            println("${ogrenci.no} numarali ogrencinin ismi ${ogrenci.name}, aldigi dersler")
            ogrenci.dersler.forEachIndexed { index, ders ->
                println("${index+1}- $ders")
            }

        }
    }


    fun enYuksekDersBul(ogrenciListesi : MutableList<Student>){
        var max = 0
        var indx = 0
        ogrenciListesi.forEachIndexed { index, ogrenci ->
            if (ogrenci.dersler.size > max){
                max = ogrenci.dersler.size
                indx = index
            }
        }
        println("En yuksek derse sahip olan Ogrenci no: ${ogrenciListesi.get(indx).no}"+
        " Isim: ${ogrenciListesi.get(indx).name}, sahip olduğu ders sayisi: ${max}")
    }


}