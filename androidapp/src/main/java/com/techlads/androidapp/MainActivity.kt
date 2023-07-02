package com.techlads.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.coroutineScope
import com.techlads.androidapp.ui.theme.Tmdb_Mobile_ApiTheme
import com.techlads.tmdbmobileapi.base.Resource
import com.techlads.tmdbmobileapi.remote.NetworkClient
import com.techlads.tmdbmobileapi.remote.datasource.TrendingTodayMoviesDataSource
import com.techlads.tmdbmobileapi.usecase.TrendingTodayMoviesUseCae
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.coroutineScope.launch {

            val networkClient = NetworkClient
            val dataSource = TrendingTodayMoviesDataSource(networkClient)
            val useCase = TrendingTodayMoviesUseCae(dataSource)
            val result = useCase.invoke()

            when (result.status) {
                Resource.Status.SUCCESS -> {
                    println("Success ${result.data}")
                }

                Resource.Status.ERROR -> {
                    println("Error")
                }

                Resource.Status.LOADING -> {
                    println("Loading")
                }

                else -> {
                    println("Default")
                }
            }

            println(result)
        }
        setContent {
            Tmdb_Mobile_ApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScoreCounter()
                }
            }
        }
    }
}

@Composable
fun ScoreCounter() {
    Text(text = "Counter")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tmdb_Mobile_ApiTheme {
        ScoreCounter()
    }
}