package com.example.data.api

import com.example.data.model.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApiService {

    @GET("tickers/")
    suspend fun getCoinList(): CoinResponse

}