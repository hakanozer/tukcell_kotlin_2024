package com.omersungur.omer_sungur_vize_3.data.mapper

import com.omersungur.omer_sungur_vize_3.data.remote.dto.AddressDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.BankDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.CompanyDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.CoordinatesDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.CryptoDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.HairDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.UserDto
import com.omersungur.omer_sungur_vize_3.data.remote.dto.UserXDto
import com.omersungur.omer_sungur_vize_3.domain.model.Address
import com.omersungur.omer_sungur_vize_3.domain.model.Bank
import com.omersungur.omer_sungur_vize_3.domain.model.Company
import com.omersungur.omer_sungur_vize_3.domain.model.Coordinates
import com.omersungur.omer_sungur_vize_3.domain.model.Crypto
import com.omersungur.omer_sungur_vize_3.domain.model.Hair
import com.omersungur.omer_sungur_vize_3.domain.model.User
import com.omersungur.omer_sungur_vize_3.domain.model.UserX

fun UserDto.toUser(): User {
    return User(
        users = users.map { it.toUserX() },
        limit = limit,
        skip = skip,
        total = total,
    )
}

fun UserXDto.toUserX(): UserX {
    return UserX(
        address = address.toAddress(),
        age = age,
        bank = bank.toBank(),
        birthDate = birthDate,
        bloodGroup = bloodGroup,
        company = company.toCompany(),
        crypto = crypto.toCrypto(),
        domain = domain,
        ein = ein,
        email = email,
        eyeColor = eyeColor,
        firstName = firstName,
        gender = gender,
        hair = hair.toHair(),
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

fun AddressDto.toAddress(): Address {
    return Address(
        address = address,
        city = city,
        coordinates = coordinates.toCoordinates(),
        postalCode = postalCode,
        state = state,
    )
}

fun CoordinatesDto.toCoordinates(): Coordinates {
    return Coordinates(
        lat = lat,
        lng = lng,
    )
}

fun BankDto.toBank(): Bank {
    return Bank(
        cardExpire = cardExpire,
        cardNumber = cardNumber,
        cardType = cardType,
        currency = currency,
        iban = iban,
    )
}

fun CompanyDto.toCompany(): Company {
    return Company(
        address = address.toAddress(),
        department = department,
        name = name,
        title = title,
    )
}

fun CryptoDto.toCrypto(): Crypto {
    return Crypto(
        network = network,
        wallet = wallet,
        coin = coin,
    )
}

fun HairDto.toHair(): Hair {
    return Hair(
        color = color,
        type = type,
    )
}
