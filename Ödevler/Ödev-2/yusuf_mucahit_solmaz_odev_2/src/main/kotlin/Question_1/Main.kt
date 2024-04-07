package Question_1


fun main() {
    val regularMenu = RegularMenu()
    val regularFood1 = MenuItem("Mercimek Çorbası", 50)
    val regularFood2 = MenuItem("Köfte", 100)
    val regularFood3 = MenuItem("Adana Kebab (Porsiyon)", 250)
    regularMenu.addFood(regularFood1)
    regularMenu.addFood(regularFood2)
    regularMenu.addFood(regularFood3)

    println("Regular Menu Items:")
    regularMenu.foodList.forEach { food ->
        println("Food: ${food.menuFoodName}, Price: ${food.menuFoodPrice}")
    }

    regularMenu.filterMenuItemsByPrice(50, 150)

    println("\nFiltered Regular Menu Items:")
    regularMenu.filteredFoodList.forEach { filteredFood ->
        println("Food: ${filteredFood.menuFoodName}, Price: ${filteredFood.menuFoodPrice}")
    }

    val vacationMenu = VacationMenu()
    val vacationFood1 = MenuItem("Ispanak Yemeği", 60)
    val vacationFood2 = MenuItem("Kuzu Tandır", 200)
    val vacationFood3 = MenuItem("Baklava", 120)
    vacationMenu.addFood(vacationFood1)
    vacationMenu.addFood(vacationFood2)
    vacationMenu.addFood(vacationFood3)

    println("\nVacation Menu Items:")
    vacationMenu.foodList.forEach { food ->
        println("Food: ${food.menuFoodName}, Price: ${food.menuFoodPrice}")
    }

    vacationMenu.filterMenuItemsByPrice(50, 150)

    println("\nFiltered Vacation Menu Items:")
    vacationMenu.filteredFoodList.forEach { filteredFood ->
        println("Food: ${filteredFood.menuFoodName}, Price: ${filteredFood.menuFoodPrice}")
    }
}