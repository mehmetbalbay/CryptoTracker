package com.example.cryptotracker.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptotracker.ui.theme.CryptotrackerTheme
import com.example.domain.model.Coin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTrackerApp()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptotrackerTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoTrackerApp() {
    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Crypto Tracker") })
            }
        ) { innerPadding ->
            HomeScreen(paddingValues = innerPadding)
        }
    }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), paddingValues: PaddingValues) {
    val coinsState = viewModel.coins.collectAsState(initial = emptyList())

    if (coinsState.value.isEmpty()) {
        Text("Yükleniyor...", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    } else {
        CoinListScreen(coins = coinsState.value, paddingValues = paddingValues)
    }
}

@Composable
fun CoinListScreen(coins: List<Coin>, paddingValues: PaddingValues) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        items(coins) { coin ->
            CoinItem(coin)
        }
    }
}

@Composable
fun CoinItem(coin: Coin) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = coin.name, style = MaterialTheme.typography.headlineSmall)
        Text(text = "${coin.price_usd} USD", style = MaterialTheme.typography.bodyMedium)
    }
}
