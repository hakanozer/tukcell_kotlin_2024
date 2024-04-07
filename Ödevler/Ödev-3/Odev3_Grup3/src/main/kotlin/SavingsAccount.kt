import java.time.LocalDate

class SavingsAccount(balance: Double, private val monthlyInterestRate: Double) : Account(balance) {

    // Para Çekme
    // Kullanıcının hesabında para yoksa para çekim işlemi başarısız.
    override fun withdraw(amount: Double) {

        if (balance - amount < 0) {
            println("Para çekme işlemi başarısız")
        } else {
            balance -= amount
            println("Hesabınızdan $amount TL para çekilmiştir.")
            println("Kalan bakiyeniz : $balance ")
        }
    }

    // Para Yatırma
    override fun deposit(amount: Double) {

        balance += amount
        println("$amount Tl yatırıldı. Yeni bakiye: $balance TL")
    }

    fun applyInterestRate() {
        if (endOfMonth()) {
            balance += balance * (monthlyInterestRate / 100)
        }
    }

    // Bu fonksiyon ay sonu kontrolünü yapmak için kullanılır.
    private fun endOfMonth(): Boolean {
        // Bugünün tarihini elde etmek için java.time paketindeki LocalDate sınıfı kullanıldı.
        val today = LocalDate.now()
        // "today.lengthOfMonth()" işlevi, geçerli aydaki toplam gün sayısını döndürür.
        // "withDayOfMonth" işlevi ayın sonunu döndürür.
        val endOfMonth = today.withDayOfMonth(today.lengthOfMonth())
        // Bugünün ayın sonu olup olmadığını kontrol ediyor.
        return today == endOfMonth

    }

    override fun toString(): String {
        return "Savings Account id:${getId()}"
    }
}