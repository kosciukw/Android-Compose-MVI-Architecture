package pl.kosciukw.petsify.shared.error.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kosciukw.petsify.shared.error.mapper.CoreDomainToAppErrorMapper
import pl.kosciukw.petsify.shared.error.mapper.impl.CoreDomainToAppErrorMapperImpl

@Module
@InstallIn(SingletonComponent::class)
object SharedErrorModule {
    //Todo rethink package placement

    @Provides
    fun providesCoreDomainToAppErrorMapper() : CoreDomainToAppErrorMapper = CoreDomainToAppErrorMapperImpl()
}