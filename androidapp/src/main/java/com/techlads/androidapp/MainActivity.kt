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
import com.dz.tmdbmobileapi.remote.GetPopularMoviesDataSource
import com.dz.tmdbmobileapi.remote.NetworkClient
import com.dz.tmdbmobileapi.usecase.GetPopularMoviesUseCase
import com.techlads.androidapp.ui.theme.Tmdb_Mobile_ApiTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.coroutineScope.launch {

            val networkClient = NetworkClient
            val dataSource = GetPopularMoviesDataSource(networkClient)
            val useCase = GetPopularMoviesUseCase(dataSource)
            val result = useCase.invoke()
            println(result)
        }
        setContent {
            Tmdb_Mobile_ApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
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
    Tmdb_Mobile_ApiTheme {
        Greeting("Android")
    }
}