import java.time.LocalDate
import java.util.UUID
fun main() {
    // kullanıcı ekleme
    val customer = Customer("011021", "Ali", "Demir")
    // tasarruf hesabı
    val time = LocalDate.now()
    val savingAccount1 = SavingsAccount(customer.id + UUID.randomUUID() ,customer, 100.0, time)
    // normal hesabı
    val checkingAccount1 = CheckingAccount(customer.id + UUID.randomUUID(), customer, 2000.0)
    // Kullanıcıya tasarruf hesabı ekleme
    customer.addAccount(savingAccount1)
    // Kullanıcıya normal hesabı ekleme
    customer.addAccount(checkingAccount1)

    println("Müşteri: ${customer.firstName} ${customer.lastName}")
    println("Tüm Hesaplar:")
    for (account in customer.getAccounts()) {
        println("Hesap ID: ${account.accountId}, Bakiye: ${account.balance}")
    }

    // Para yatırma ve çekme işlemleri
    println("Hesaptaki bakiye: ${savingAccount1.balance}")
    savingAccount1.deposit(100.0)
    savingAccount1.withdraw(300.0)

    println("Hesaptaki bakiye: ${checkingAccount1.balance}")
    checkingAccount1.deposit(1000.0)
    checkingAccount1.withdraw(500.0)

    // Aylık faiz uygulama
    savingAccount1.applyMonthlyInterest()

    // Kullanıcıya ait tüm hesaplar ve bakiyeleri
    println("Müşteri ${customer.firstName} ${customer.lastName} ' nin Tüm hesapları : ")
    for (account in customer.getAccounts()) {
        println("Hesap ID: ${account.accountId}, Bakiye: ${account.balance}")
    }
    // Kullanıcının hesabını silme
    customer.removeAccount(savingAccount1)
}