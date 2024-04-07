fun main() {


    val customer1 = Customer("Selin", "Cengiz")

    println("Bankamıza hoşgeldiniz ${customer1.name}! Size nasıl yardımcı olabiliriz.")

    customer1.applyInterestRate()

    while (true) {
        println("1.Hesap Aç")
        println("2.Para Yatır")
        println("3.Para Çek")
        println("4.Hesap Bakiyesini Kontrol Et")
        println("5.Çıkış")

        val choice = readlnOrNull()?.toInt()

        when (choice) {

            1 -> {
                println("Hesap türünü seçiniz.")
                println("1.Checking Account")
                println("2.Saving Account")

                val accountType = readlnOrNull()?.toInt()

                when (accountType) {
                    1 -> {
                        customer1.createAccount(CheckingAccount(0.0, 5.0))
                        println("Hesabınız oluşturuldu.")
                    }

                    2 -> {
                        customer1.createAccount(SavingsAccount(0.0, 5.0))
                        println("Hesabınız oluşturuldu.")

                    }

                    else -> {
                        println("Geçersiz Seçim!")
                    }
                }
            }

            2 -> {
                println("Para yatırmak istediğiniz hesabı seçiniz")

                customer1.getAllAccount().forEachIndexed { index, item ->
                    println("${index + 1}- $item")
                }

                val account = readLine()?.toIntOrNull()


                if (account != null && account in (1..customer1.getAllAccount().size)) {
                    println("Yatırmak istediğiniz miktarı giriniz.")
                    val amount = readLine()?.toDoubleOrNull()

                    if (amount != null) {
                        customer1.getAllAccount().elementAt(account - 1).deposit(amount)

                    }

                } else {
                    println("Geçersiz seçim")
                }


            }

            3 -> {
                println("Para çekmek istediğiniz hesabı seçiniz")

                customer1.getAllAccount().forEachIndexed { index, item ->
                    println("${index + 1}- $item")
                }

                val account = readLine()?.toIntOrNull()


                if (account != null && account in (1..customer1.getAllAccount().size)) {
                    println("Çekmek istediğiniz miktarı giriniz.")
                    val amount = readLine()?.toDoubleOrNull()

                    if (amount != null) {
                        customer1.getAllAccount().elementAt(account - 1).withdraw(amount)
                    }

                } else {
                    println("Geçersiz seçim")
                }
            }

            4 -> {

                customer1.checkBalance()
            }

            5 -> {
                println("Çıkış Yapılıyor..")
                break

            }

            else -> {
                println("Geçersiz seçim")
            }

        }
    }


}