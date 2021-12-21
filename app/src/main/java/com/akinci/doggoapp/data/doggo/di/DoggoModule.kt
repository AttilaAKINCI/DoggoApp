package com.akinci.doggoapp.data.doggo.di

import com.akinci.doggoapp.common.repository.BaseRepository
import com.akinci.doggoapp.data.doggo.api.DoggoServiceDao
import com.akinci.doggoapp.data.doggo.repository.DoggoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DoggoModule {

    @Provides
    @Singleton
    fun provideDoggoService(
        retrofit: Retrofit
    ): DoggoServiceDao = retrofit.create(DoggoServiceDao::class.java)

    @Provides
    @Singleton
    fun provideDoggoRepository(
        doggoServiceDao: DoggoServiceDao,
        baseRepository: BaseRepository
    ) = DoggoRepository(doggoServiceDao, baseRepository)

}