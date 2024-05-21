package com.omersungur.omer_sungur_vize_3.di

import com.omersungur.omer_sungur_vize_3.data.remote.UserApi
import com.omersungur.omer_sungur_vize_3.data.repository.UserRepositoryImpl
import com.omersungur.omer_sungur_vize_3.domain.repository.UserRepository
import com.omersungur.omer_sungur_vize_3.domain.use_case.get_users_use_case.GetUsersUseCase
import com.omersungur.omer_sungur_vize_3.domain.use_case.UserUseCase
import com.omersungur.omer_sungur_vize_3.domain.use_case.filter_users_use_case.FilterUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(userApi: UserApi): UserRepository {
        return UserRepositoryImpl(userApi)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        userRepository: UserRepository,
    ): UserUseCase {
        return UserUseCase(
            getUsersUseCase = GetUsersUseCase(userRepository),
            filterUsersUseCase = FilterUsersUseCase(userRepository)
        )
    }
}