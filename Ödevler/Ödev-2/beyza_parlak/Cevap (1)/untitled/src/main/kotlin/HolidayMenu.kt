// Menu classını miras alıyorum. Menu classının başına open kavramını ekledim
class HolidayMenu: Menu() {
    init {
        // tatil menulerini ve fiyatlarını ekliyorum
        addFoodToMenu("Tatil Menu 1", 250.0)
        addFoodToMenu("Tatil Menu 2", 600.0)
        addFoodToMenu("Tatil Menu 3", 350.5)
        addFoodToMenu("Tatil Menu 4", 420.0)
    }

}