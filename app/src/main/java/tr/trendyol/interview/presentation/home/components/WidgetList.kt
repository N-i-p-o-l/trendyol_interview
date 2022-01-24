package tr.trendyol.interview.presentation.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tr.trendyol.interview.domain.entity.DisplayType
import tr.trendyol.interview.domain.entity.Type
import tr.trendyol.interview.presentation.home.HomeViewModel

@Composable
fun WidgetList(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val isLoading by remember {
        viewModel.isLoading
    }
    val loadError by remember {
        viewModel.loadError
    }
    val widgets by remember {
        viewModel.widgets
    }

    LazyColumn() {
        items(widgets.size - 1) {
            val widget = widgets[it]
            when (widget.displayType) {
                DisplayType.SINGLE -> {
                    when (widget.type) {
                        Type.BANNER -> {
                            if (widget.bannerContents.isNotEmpty()) {
                                BannerContent(banner = widget.bannerContents[0])
                                Spacer(modifier = Modifier.size(16.dp))
                            }
                        }
                        Type.PRODUCT -> {
                        }
                        Type.SLIDER -> {
                        }
                    }
                }
                DisplayType.SLIDER -> {
                    when (widget.type) {
                        Type.BANNER -> {
                        }
                        Type.PRODUCT -> {
                        }
                        Type.SLIDER -> {
                        }
                    }
                }
            }
        }
    }
}