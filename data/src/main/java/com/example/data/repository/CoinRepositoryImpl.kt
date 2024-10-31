package com.example.data.repository

import android.util.Log
import com.example.data.api.CoinApiService
import com.example.domain.model.Coin
import com.example.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CoinApiService
) : CoinRepository {

    override fun getCoins(): Flow<List<Coin>> = flow {
        val coins = apiService.getCoinList().data.map { it.toDomain() }
        emit(coins)
    }.catch { e ->
        throw Exception("Failed to fetch coins: ${e.message}")
    }

}