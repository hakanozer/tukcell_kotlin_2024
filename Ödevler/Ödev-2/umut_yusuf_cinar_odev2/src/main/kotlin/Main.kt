///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

//Ödevde belirtilen 5 senaryo için ayrı klasörler oluşturup
//Bu klasörler içerisinde sınıfları organiza ettikten sonra
//Tüm senaryoların gerçekleşebilmesi için sınıflardan nesneler oluşturup.
//Nesneler üzerinden gerekli senaryoları gerçekleştireceğim.

package org.example
import org.example.soru1.HolidayMenu
import org.example.soru1.Menu
import org.example.soru2.GeniusStudents
import org.example.soru2.Student
import org.example.soru3.Carnivore
import org.example.soru3.Herbivore
import org.example.soru3.Omnivore
import org.example.soru3.Zoo
import org.example.soru4.Encyclopedia
import org.example.soru4.Library
import org.example.soru5.OnlineSalerUmut
import org.example.soru5.OnlineSalerYusuf
import org.example.soru5.Product

fun main() {

    //Soruların çalıştığını kolayca ve tek bir yerden denetleyebilmeniz için ayrı ayrı main oluşturmadım hocam.

    //1. Soruyu Çağırdığım Kısım:

    //Önce normal bir menü oluşturuyorum.
    val defaultMenu = Menu()
    //Menüye çeşitli öğeler (sevdiğim yemekler :D) ve fiyatları ekliyorum.
    defaultMenu.addItemToMenu(itemName = "Biftek", price = 350.0, isFresh = true)
    defaultMenu.addItemToMenu(itemName = "Pide", price = 150.0, isFresh = false)
    defaultMenu.addItemToMenu(itemName = "Kış Salatası", price = 40.0, isFresh = true)
    defaultMenu.addItemToMenu(itemName = "Kelle Paça Çorbası", price = 90.0, isFresh = false)
    defaultMenu.addItemToMenu(itemName = "Baklava (Porsiyon)", price = 180.0, isFresh = true)

    //Belirli bir fiyat aralığındaki öğeleri listeliyorum ve ekrana bastırıyorum.
    println("\nNormal Menüdeki 100 ile 200 lira arasındaki ürünler:")
    defaultMenu.listItemsByPriceRange(100.0, 200.0).forEach { println(it) }

    //Özel tatil menüsünü oluşturuyorum.
    val holidayMenu = HolidayMenu()
    //Tatil menüsüne çeşitli özel tatil öğeleri ve fiyatları ekliyorum.
    //Normalde çıtır tavuk 100 ile 200 arasında olmasına rağmen
    //polimorfizmle override edilen fonksiyondan
    //bayat olduğu için price = 55 olarak döndü ve ekrana bastırılmadı.
    holidayMenu.addItemToMenu(itemName = "Çıtır Tavuk", price = 110.0, isFresh = false)
    holidayMenu.addItemToMenu(itemName = "Pizza", price = 150.0, isFresh = true)
    holidayMenu.addItemToMenu(itemName = "Patates Kızartması", price = 60.0, isFresh = false)
    holidayMenu.addItemToMenu(itemName = "San Sebastian", price = 210.0, isFresh = false)

    // Belirli bir fiyat aralığındaki öğeleri listeliyoruz ve ekrana yazdırıyoruz
    println("\nTatil Menüsündeki 100 ile 200 lira arasındaki ürünler:")
    holidayMenu.listItemsByPriceRange(100.0, 200.0).forEach { println(it) }


    //2. Soruyu Çağırdığım Kısım:

    //Öğrenci eklemesi yapıp bu öğrecileri listeliyorum.
    val student1 = Student(name = "Umut Yusuf", sirName = "Çınar", number = 123, listOf("Mobil Programlama", "İşletim Sistemleri", "Yapay Sinir Ağları"))
    val student2 = Student(name = "Yahya", sirName = "Kemal", number = 456, listOf("Tarih", "Edebiyat"))
    val student3 = Student(name = "Orhan Veli", sirName = "Kanık", number = 789, listOf("Fransızca", "İngilizce", "Türkçe", "Edebiyat"))

    val students = listOf(student1, student2, student3)

    //Listelenen öğrencileri ekrana bastırıyorum.
    println("Öğrencilerin Aldığı Dersler:")
    for (student in students) {
        println("${student.name} ${student.sirName} isimli öğrencinin aldığı dersler: ${student.courses.joinToString(", ")}")
    }

    val topStudents = GeniusStudents.findGeniusStudents(students)
    if (topStudents.isNotEmpty()) { //null kontrolü
        println("\nEn Yüksek Ders Sayısına Sahip Öğrenciler:")
        for (topStudent in topStudents) {
            println("${topStudent.name} ${topStudent.sirName}, aldığı dersler: ${topStudent.courses.joinToString(", ")}")
            topStudent.awardScholarship()
        }
    } else {
        println("\nÖğrenci bulunamadı.")
    }


    //3. Soruyu Çağırdığım Kısım:

    //Farklı hayvanların örneklerini oluşturuyorum.
    val animals = listOf(
        Carnivore(name = "Aslan", species = "Memeli", diet = "Etçil", habitat = "Kara"),
        Carnivore(name = "Kurt", species = "Memeli", diet = "Etçil", habitat = "Kara"),
        Herbivore(name = "Geyik", species = "Memeli", diet = "Otçul", habitat = "Kara"),
        Omnivore(name = "Ayı", species = "Memeli", diet = "Etçil ve Otçul", habitat = "Kara"),
        Omnivore(name = "Balina", species = "Memeli", diet = "Etçil ve Otçul", habitat = "Su")
    )

    //Hayvanları içeren bir hayvanat bahçesi oluşturuyorum.
    val zoo = Zoo(animals)

    //Hayvanat bahçesindeki suda yaşayan hayvanları listeliyorum.
    //Su değerini parametre ile alarak güncellenebilir bir kod yapısı oluşturdum.
    zoo.listAnimalsInHabitat(habitat = "Su")

    //Hayvanat bahçesindeki etçil hayvanları listeliyorum.
    //Etçil değerini parametre ile alarak güncellenebilir bir kod yapısı oluşturdum.
    zoo.listAnimalsByDiet(diet = "Etçil")


    //4. Soruyu Çağırdığım Kısım:

        val library = Library()
        library.addBookToListWithWriter(book = "Esir Şehir İstanbul", writerName = "Yahya Kemal")
        library.addBookToListWithWriter(book = "Kuyucaklı Yusuf", writerName = "Sabahattin Ali")
        library.addBookToListWithWriter(book = "Kumarbaz", writerName = "Dostoyevski")
        library.addBookToListWithWriter(book = "Ezilenler", writerName = "Dostoyevski")
        library.addBookToListWithWriter(book = "Suç ve Ceza", writerName = "Dostoyevski")
        library.addBookToListWithWriter(book = "İnsan Ne ile Yaşar", writerName = "Tolstoy")
        library.removeBookFromListWithWriter(book = "İnsan Ne ile Yaşar", writerName = "Tolstoy")

        println("Tüm kitaplar:")
        library.listBooks()

        println()

        library.listBooksByWriter(writerName = "Dostoyevski")

        val encyclopedia = Encyclopedia(name = "Dünya Ansiklopedisi", writerNamesOfEncyclopedia = "Birçok",
            serialNumber = 1, specialBookCover = "Ciltlenmiş (Sert Kapak)")
        println("Ansiklopedinin dış kapak türü: ${encyclopedia.specialBookCover}")

    //5. Soruyu Çağırdığım Kısım:
    val umut = OnlineSalerUmut()
    umut.addProduct(Product(name = "Telefon", price = 3000.0))
    umut.addProduct(Product(name = "Dizüstü Bİlgisayar", price = 5000.0))
    umut.totalSpending()

    val yusuf = OnlineSalerYusuf()
    yusuf.addProduct(Product(name = "Kulaklık", price = 200.0))
    yusuf.addProduct(Product(name = "Klavye", price = 150.0))
    yusuf.addProduct(Product(name = "Mouse", price = 100.0))
    yusuf.totalSpending()
    }



