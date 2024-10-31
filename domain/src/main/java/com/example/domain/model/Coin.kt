package com.example.domain.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val price_usd: Double,
    val market_cap_usd: Double,
    val rank: String
)