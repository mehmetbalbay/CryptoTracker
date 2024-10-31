package com.example.domain.usecase

import com.example.domain.model.Coin
import com.example.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){

    operator fun invoke(): Flow<List<Coin>> = repository.getCoins()

}