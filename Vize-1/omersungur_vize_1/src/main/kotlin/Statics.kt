package org.example

class Statics {
    // Her yeni müşteri nesnesi için farklı bir id oluşturmak ve bu id'yi sürekli arttırmak
    // üzerine static bir yapı ile tutuyorum. Ek olarak bu yapınınprogramda tek bir tane olması lazım.
    companion object {
        var customerIdCounter = 1
    }
}