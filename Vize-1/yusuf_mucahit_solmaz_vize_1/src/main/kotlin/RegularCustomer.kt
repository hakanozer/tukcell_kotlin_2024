class RegularCustomer(
    name: String,
    email: String,
    phone: String,
    customerId: String,
    var loyaltyPoints: Int
) : Customer(name, email, phone, customerId)