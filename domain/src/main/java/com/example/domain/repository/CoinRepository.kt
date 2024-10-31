package com.example.domain.repository

import com.example.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getCoins(): Flow<List<Coin>>
}