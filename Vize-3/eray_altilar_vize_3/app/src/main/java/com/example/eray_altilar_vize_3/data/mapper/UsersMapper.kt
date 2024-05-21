package com.example.eray_altilar_vize_3.data.mapper

import com.example.eray_altilar_vize_3.data.remote.dto.Address
import com.example.eray_altilar_vize_3.data.remote.dto.Bank
import com.example.eray_altilar_vize_3.data.remote.dto.Company
import com.example.eray_altilar_vize_3.data.remote.dto.Coordinates
import com.example.eray_altilar_vize_3.data.remote.dto.Crypto
import com.example.eray_altilar_vize_3.data.remote.dto.Hair
import com.example.eray_altilar_vize_3.data.remote.dto.User
import com.example.eray_altilar_vize_3.data.remote.dto.Users
import com.example.eray_altilar_vize_3.domain.model.AddressModel
import com.example.eray_altilar_vize_3.domain.model.BankModel
import com.example.eray_altilar_vize_3.domain.model.CompanyModel
import com.example.eray_altilar_vize_3.domain.model.CoordinatesModel
import com.example.eray_altilar_vize_3.domain.model.CryptoModel
import com.example.eray_altilar_vize_3.domain.model.HairModel
import com.example.eray_altilar_vize_3.domain.model.UserModel
import com.example.eray_altilar_vize_3.domain.model.UsersModel


fun Users.toUsersModel(): UsersModel {
    return UsersModel(
        users = users.map { it.toUserModel() },
        limit = limit,
        skip = skip,
        total = total,
    )
}

fun User.toUserModel() : UserModel {
    return UserModel(
        address = address.toAddressModel(),
        age = age,
        bank = bank.toBankModel(),
        birthDate = birthDate,
        bloodGroup = bloodGroup,
        company = company.toCompanyModel(),
        crypto = crypto.toCryptoModel(),
        domain = domain,
        ein = ein,
        email = email,
        eyeColor = eyeColor,
        firstName = firstName,
        gender = gender,
        hair = hair.toHairModel(),
        height = height,
        id = id,
        image = image,
        ip = ip,
        lastName = lastName,
        macAddress = macAddress,
        maidenName = maidenName,
        password = password,
        phone = phone,
        ssn = ssn,
        university = university,
        userAgent = userAgent,
        username = username,
        weight = weight,
    )
}

// Address
fun Address.toAddressModel(): AddressModel {
    return AddressModel(
        address = address,
        city = city,
        coordinates = coordinates.toCoordinatesModel(),
        postalCode = postalCode,
        state = state,
    )
}

fun Coordinates.toCoordinatesModel(): CoordinatesModel {
    return CoordinatesModel(
        lat = lat,
        lng = lng,
    )
}

// Bank
fun Bank.toBankModel(): BankModel {
    return BankModel(
        cardExpire = cardExpire,
        cardNumber = cardNumber,
        cardType = cardType,
        currency = currency,
        iban = iban,
    )
}

// Company
fun Company.toCompanyModel(): CompanyModel {
    return CompanyModel(
        address = address.toAddressModel(),
        department = department,
        name = name,
        title = title,
    )
}

// Crypto
fun Crypto.toCryptoModel(): CryptoModel {
    return CryptoModel(
        network = network,
        wallet = wallet,
        coin = coin,
    )
}

// Hair
fun Hair.toHairModel(): HairModel {
    return HairModel(
        color = color,
        type = type,
    )
}
