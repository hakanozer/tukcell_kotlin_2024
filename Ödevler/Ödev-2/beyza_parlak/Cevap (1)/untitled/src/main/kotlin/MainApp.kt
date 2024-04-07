fun main(){
    // Menu sınıfı için object oluşturdum ve hemen altında menuye ekleme yaptım
    val menu = Menu()
    menu.addFoodToMenu("Adana Kebap", 230.0)
    menu.addFoodToMenu("Tavuk Izgara", 160.0)
    menu.addFoodToMenu("Et Izgara", 260.5)
    menu.addFoodToMenu("Tavuk Şiş", 155.5)
    menu.addFoodToMenu("Kağıt Kebabı", 350.0)
    menu.addFoodToMenu("Künefe", 100.0)
    menu.addFoodToMenu("Mercimek Çorbası", 50.0)
    menu.addFoodToMenu("Çay",15.0)
    menu.addFoodToMenu("Kahvaltı Tabağı",160.0)
    menu.addFoodToMenu("Türk Kahvesi",40.0)
    menu.addFoodToMenu("Dibek Kahvesi",45.0)
    menu.addFoodToMenu("Çoban Salata", 70.0)
    menu.addFoodToMenu("Pirinç Pilavı", 50.0)
    menu.addFoodToMenu("Bulgur Pilavı", 50.0)

    // filtreleme işlemini gerçekleştirmek için bir değişken oluşturdum ve içinde menu sınıfına ait filreleme fonk çağırdım
    val filter1 = menu.listFoodsByPriceRange(0.0,50.0)
    println("Menude 0-50 TL arası ürünler : $filter1")

    // holidayMenu sınıfı için object oluşturdum ve hemen altında menuye ekleme yaptım
    val holidayMenu = HolidayMenu()
    holidayMenu.addFoodToMenu("Tatil Tatlısı 1", 120.0)
    holidayMenu.addFoodToMenu("Tatil Tatlısı 2", 130.0)
    holidayMenu.addFoodToMenu("Tatil Tatlısı 3", 60.0)
    holidayMenu.addFoodToMenu("Tatil Tatlısı 4", 110.0)

    // filtreleme işlemini gerçekleştirmek için bir değişken oluşturdum ve içinde menu sınıfına ait miras aldığım filreleme fonk çağırdım
    val filter2 = holidayMenu.listFoodsByPriceRange(100.0, 400.0)
    println("Tatil Menusu 100-400 TL arası ürünler : $filter2")


}