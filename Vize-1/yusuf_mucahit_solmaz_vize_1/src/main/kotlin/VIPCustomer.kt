class VIPCustomer(
    name: String,
    email: String,
    phone: String,
    customerId: String,
    var vipLevel: Int
) : Customer(name, email, phone, customerId)