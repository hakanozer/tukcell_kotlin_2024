fun main() {
    // Customer Nesnesi
    val customer = Customer("Mehmet", "Yılmaz")

    // Checking Account Nesnesi
    val checkingAccount = CheckingAccount("1", 1000.0)

    // Hesap ekleme
    customer.addAccount(checkingAccount)
    // Aynı hesabı eklerken kontrol ettiriyoruz, eğer varsa eklemiyoruz.
    customer.addAccount(checkingAccount)

    // Para yatırma - çekme işlemleri
    customer.withdraw("1", 250.0)
    customer.withdraw("1", 100.0)
    customer.withdraw("1", 200.0)
    customer.deposit("1", 400.0)
    customer.deposit("1", 700.0)
    customer.deposit("1", 800.0)
    customer.deposit("1", 900.0)

    // Bakiye kontrolü
    customer.checkBalance("1")

    // Son 5 işlemi yazdır
    customer.printLastFiveProcess()

    // Farklı bir hesap nesnesi
    val customer2 = Customer("Mehmet", "Yılmaz")

    // Saving Account Nesnesi
    val savingsAccount = SavingsAccount("1", 2500.0, 0.1)

    // Hesap ekleme
    customer2.addAccount(savingsAccount)

    // Ay sonu faizle birlikte oluşan bakiye
    savingsAccount.addMonthlyInterestRate()

    // Döviz dönüştürücü nesnesi
    val currencyConverter = CurrencyConverter()

    // Döviz dönüştürme
    println(currencyConverter.convert(50.0, "USD", "TR"))
}