package tr.trendyol.interview.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import tr.trendyol.interview.R
import tr.trendyol.interview.domain.entity.BannerContent
import tr.trendyol.interview.presentation.home.components.Banner

@Composable
fun DetailScreen(
    banner: BannerContent,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.wrapContentSize(),
            ) {
                Text(text = banner.title)
            }
        },
        backgroundColor = colorResource(R.color.orange),
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Banner(banner = banner, navToDetail = {})
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = banner.title, fontSize = 24.sp)
    }
}