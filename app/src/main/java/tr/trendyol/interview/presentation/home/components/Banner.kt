package tr.trendyol.interview.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import tr.trendyol.interview.domain.entity.BannerContent

@Composable
fun Banner(
    banner: BannerContent,
    navToDetail: (BannerContent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .wrapContentSize()
            .clickable {
                navToDetail(banner)
            }
    ) {
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val widthHeight = configuration.screenWidthDp.dp

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(widthHeight)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = banner.imageUrl,
                    builder = {
                        crossfade(true)
                        size(OriginalSize)
                    }
                ),
                contentDescription = banner.title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}