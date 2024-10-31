package com.example.data

import com.example.data.api.CoinApiService
import com.example.data.repository.CoinRepositoryImpl
import com.example.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCoinApiService(retrofit: Retrofit): CoinApiService {
        return retrofit.create(CoinApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(apiService: CoinApiService): CoinRepository {
        return CoinRepositoryImpl(apiService)
    }

}