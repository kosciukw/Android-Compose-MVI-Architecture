package com.kosciukw.services.user.di

import com.kosciukw.services.user.repository.UserRepository
import com.kosciukw.services.user.repository.impl.UserRepositoryMockImpl
import com.kosciukw.services.user.repository.impl.UserRepositoryRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        mockUserRepository: UserRepositoryMockImpl
    ): UserRepository = UserRepositoryRemoteImpl(mockUserRepository)
}