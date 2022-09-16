package com.example.cityapp.di

import com.example.cityapp.data.repo.CityDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideCityDaoRepository() : CityDaoRepository {
        return CityDaoRepository()              //var cRepo = CityDaoRepository() ile aynı anlama geliyor.
    }
}