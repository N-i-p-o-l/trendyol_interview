package tr.trendyol.interview.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tr.trendyol.interview.common.Resource
import tr.trendyol.interview.domain.entity.Widget
import tr.trendyol.interview.domain.repository.TrendYolRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val repository: TrendYolRepository) : ViewModel() {

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var widgets = mutableStateOf<List<Widget>>(listOf())

    init {
        loadWidgets()
    }

    fun loadWidgets() {
        viewModelScope.launch {
            isLoading.value = true

            when(val result = repository.getWidgets()) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    isLoading.value = false

                    if (result.data != null) {
                        loadError.value = ""
                        widgets.value = result.data.widgets
                    }
                    else {
                        loadError.value = result.message ?: "Unknown Error"
                    }
                }
                is Resource.Error -> {
                    loadError.value = result.message ?: "Unknown Error"
                    isLoading.value = false
                }
            }
        }
    }
}