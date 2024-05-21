package com.selincengiz.selin_cengiz_vize3.data.mapper


import com.selincengiz.selin_cengiz_vize3.data.entities.Address
import com.selincengiz.selin_cengiz_vize3.data.entities.Bank
import com.selincengiz.selin_cengiz_vize3.data.entities.Company
import com.selincengiz.selin_cengiz_vize3.data.entities.Coordinates
import com.selincengiz.selin_cengiz_vize3.data.entities.Crypto
import com.selincengiz.selin_cengiz_vize3.data.entities.Hair
import com.selincengiz.selin_cengiz_vize3.data.entities.User
import com.selincengiz.selin_cengiz_vize3.domain.entities.AddressUI
import com.selincengiz.selin_cengiz_vize3.domain.entities.BankUI
import com.selincengiz.selin_cengiz_vize3.domain.entities.CompanyUI
import com.selincengiz.selin_cengiz_vize3.domain.entities.CoordinatesUI
import com.selincengiz.selin_cengiz_vize3.domain.entities.CryptoUI
import com.selincengiz.selin_cengiz_vize3.domain.entities.HairUI
import com.selincengiz.selin_cengiz_vize3.domain.entities.UserUI

fun User.mapToUserUI(): UserUI {
    return UserUI(
        address?.mapToAddressUI(),
        age,
        bank?.mapToBankUI(),
        birthDate,
        bloodGroup,
        company?.mapToCompanyUI(),
        crypto?.mapToCryptoUI(),
        domain,
        ein,
        email,
        eyeColor,
        firstName,
        gender,
        hair?.mapToHairUI(),
        height,
        id,
        image,
        ip,
        lastName,
        macAddress,
        maidenName,
        password,
        phone,
        ssn,
        university,
        userAgent,
        username,
        weight
    )
}

fun Address.mapToAddressUI(): AddressUI {
    return AddressUI(
        address,
        city,
        coordinates?.mapToCoordinatesUI(),
        postalCode,
        state
    )
}

fun Bank.mapToBankUI(): BankUI {
    return BankUI(
        cardExpire,
        cardNumber,
        cardType,
        currency,
        iban,
    )
}

fun Company.mapToCompanyUI(): CompanyUI {
    return CompanyUI(
        address?.mapToAddressUI(),
        department,
        name,
        title,
    )
}

fun Coordinates.mapToCoordinatesUI(): CoordinatesUI {
    return CoordinatesUI(
        lat,
        lng,
    )
}

fun Crypto.mapToCryptoUI(): CryptoUI {
    return CryptoUI(
        coin,
        network,
        wallet,
    )
}

fun Hair.mapToHairUI(): HairUI {
    return HairUI(
        color,
        type,
    )
}

