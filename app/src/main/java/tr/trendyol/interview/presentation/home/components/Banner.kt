package tr.trendyol.interview.presentation.home.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil.bitmap.BitmapPool
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import coil.size.Size
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.Transformation
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