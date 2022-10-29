package com.example.cityapp.di

import com.example.cityapp.data.repo.CityDaoRepository
import com.example.cityapp.retrofit.ApiUtils
import com.example.cityapp.retrofit.WeatherInfoDao
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
    fun provideCityDaoRepository(cDao: WeatherInfoDao): CityDaoRepository {
        return CityDaoRepository(cDao)              //var cRepo = CityDaoRepository() ile aynı anlama geliyor.
    }

    @Provides
    @Singleton
    fun provideWeatherInfoDao(): WeatherInfoDao {
        return ApiUtils.getWeatherInfoDao()
    }
}