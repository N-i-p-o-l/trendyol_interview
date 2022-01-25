package tr.trendyol.interview.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import tr.trendyol.interview.theme.TrendYolTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrendYolTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TrendYolApp()
                }
            }
        }
    }
}