package tr.trendyol.interview.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import tr.trendyol.interview.presentation.home.HomeScreen
import tr.trendyol.interview.theme.TrendYolTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrendYolTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "home") {
                    composable(route = "home") {
                        HomeScreen(navController = navController)
                    }
                }
            }
        }
    }
}