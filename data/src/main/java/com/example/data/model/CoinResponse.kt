package com.example.data.model

import com.example.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("data")
    val data: List<CoinData>
)

data class CoinData(
    val id: String,
    val symbol: String,
    val name: String,
    val price_usd: Double,
    val market_cap_usd: Double,
    val rank: String
) {
    fun toDomain(): Coin {
        return Coin(
            id = id,
            symbol = symbol,
            name = name,
            price_usd = price_usd,
            market_cap_usd = market_cap_usd,
            rank = rank
        )
    }
}