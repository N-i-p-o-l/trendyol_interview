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

    var isLoading = mutableStateOf(false)
    var loadError = mutableStateOf("")
    var widgets = mutableStateOf<List<Widget>>(listOf())

    fun loadWidgets() {
        viewModelScope.launch {
            isLoading.value = true

            when(val result = repository.getWidgets()) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    loadError.value = ""
                    isLoading.value = false

                    result.data?.let {
                        widgets.value = it.widgets
                    }
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
            }
        }
    }
}