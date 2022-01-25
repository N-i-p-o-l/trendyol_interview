package tr.trendyol.interview.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tr.trendyol.interview.domain.entity.BannerContent
import tr.trendyol.interview.domain.entity.DisplayType
import tr.trendyol.interview.domain.entity.Type
import tr.trendyol.interview.presentation.home.HomeViewModel

@Composable
fun WidgetList(
    viewModel: HomeViewModel,
    navToDetail: (BannerContent) -> Unit
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

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
    ) {
        items(widgets.size - 1) {
            val widget = widgets[it]
            when (widget.displayType) {
                DisplayType.SINGLE -> {
                    when (widget.type) {
                        Type.BANNER -> {
                            if (widget.bannerContents.isNotEmpty()) {
                                Banner(widget.bannerContents[0], navToDetail)
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                        else -> {}
                    }
                }
                DisplayType.SLIDER -> {
                    when (widget.type) {
                        Type.BANNER -> {
                            if (widget.bannerContents.isNotEmpty()) {
                                LazyRow() {
                                    items(widget.bannerContents.size - 1) { row ->
                                        Product(widget.bannerContents[row], navToDetail)
                                        Spacer(modifier = Modifier.width(8.dp))
                                    }
                                }
                            }
                        }
                        Type.PRODUCT -> {
                            // Couldn't find products field
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if (loadError.isNotEmpty()) {
            RetrySection(error = loadError) {
                viewModel.loadWidgets()
            }
        }
    }
}