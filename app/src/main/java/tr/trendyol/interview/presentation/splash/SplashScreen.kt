package tr.trendyol.interview.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import tr.trendyol.interview.R

@Composable
fun SplashScreen(
    onFinished: () -> Unit
) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(2000L)
        onFinished()
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()) {
        Text(stringResource(R.string.app_name),
            fontSize = 48.sp, fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.orange))
    }
}