package tr.trendyol.interview.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import okhttp3.internal.wait
import tr.trendyol.interview.R
import tr.trendyol.interview.domain.entity.BannerContent
import tr.trendyol.interview.presentation.home.components.WidgetList

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navToDetail: (BannerContent) -> Unit
    )
{
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(stringResource(R.string.home))
                    }
                },
                backgroundColor = colorResource(R.color.orange)
            )
            WidgetList(viewModel, navToDetail)
        }
    }
}