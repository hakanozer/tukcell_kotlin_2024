class CurrencyConverter {
    private val excRates = mutableMapOf<String, Double>()

    // Dönüştürülmek istenen para birimleri ve döviz oranları tanımlama
    init {
        excRates["USD"] = 1.0
        excRates["TR"] = 33.0
        excRates["EUR"] = 0.94
    }

    // Belirli bir miktarı dövizden diğerine çevirme
    fun convert(amount: Double, from: String, to: String): Double? {
        val fromRate = excRates[from]
        val toRate = excRates[to]

        if (fromRate != null && toRate != null) {
            return amount * toRate / fromRate
        }

        return null
    }
}