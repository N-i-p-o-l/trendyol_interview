package tr.trendyol.interview.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors()

private val DarkColorPalette = darkColors()

@Composable
fun TrendYolTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    }
    else {
        LightColorPalette
    }

    MaterialTheme (
        colors = colors,
        content = content
    )
}