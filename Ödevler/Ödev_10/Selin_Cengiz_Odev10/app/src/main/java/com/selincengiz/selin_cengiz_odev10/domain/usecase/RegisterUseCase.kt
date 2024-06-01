package com.selincengiz.selin_cengiz_odev10.domain.usecase

import com.selincengiz.selin_cengiz_odev10.common.Resource
import com.selincengiz.selin_cengiz_odev10.data.entities.UserRoom
import com.selincengiz.selin_cengiz_odev10.domain.repo.IUserRepo


class RegisterUseCase(private val userRepo: IUserRepo) {

    suspend operator fun invoke(
        email: String?,
        password: String?,
        passwordConfirm: String?,
    ): Resource<String> {
        if (email.isNullOrEmpty() || password.isNullOrEmpty() || passwordConfirm.isNullOrEmpty()) {
            return Resource.Error(Exception("Please fill in the blanks."))
        }

        if (password.length < 6) {
            return Resource.Error(Exception("Password must be at least 6 characters."))
        }

        if (password != passwordConfirm) {
            return Resource.Error(Exception("Passwords must be matched!"))
        }

        val user = UserRoom(email, password)
        userRepo.insertUser(user)
        return Resource.Success("Successfully registered.")
    }
}