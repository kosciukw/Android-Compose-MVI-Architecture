package com.kosciukw.services.data.user.service.user.error.di

import com.kosciukw.services.data.user.service.user.error.UserDomainToAppErrorMapper
import com.kosciukw.services.data.user.service.user.error.impl.UserDomainToAppErrorMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserServiceModule {

    @Provides
    fun providesUserDomainToAppErrorMapper(): UserDomainToAppErrorMapper =
        UserDomainToAppErrorMapperImpl()
}