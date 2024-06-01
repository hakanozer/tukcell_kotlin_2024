package com.selincengiz.selin_cengiz_odev10.domain.usecase

import com.selincengiz.selin_cengiz_odev10.common.Resource
import com.selincengiz.selin_cengiz_odev10.domain.repo.IUserRepo

class LoginUseCase(private val userRepo: IUserRepo) {

    suspend operator fun invoke(
        email: String?,
        password: String?
    ): Resource<String> {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            return Resource.Error(Exception("Please fill in the blanks."))
        }

        if (password.length < 6) {
            return Resource.Error(Exception("Password must be at least 6 characters."))
        }

        return if (userRepo.isUserExist(email, password) > 0) {
            Resource.Success("Successfully logined.")
        } else {
            Resource.Error(Exception("User not found."))
        }

    }
}