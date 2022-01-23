package tr.trendyol.interview.data.repository

import dagger.hilt.android.scopes.ActivityScoped
import tr.trendyol.interview.common.Resource
import tr.trendyol.interview.data.TrendYolApi
import tr.trendyol.interview.domain.entity.ListWidgets
import tr.trendyol.interview.domain.repository.TrendYolRepository
import javax.inject.Inject

@ActivityScoped
class TrendYolRepositoryImpl @Inject constructor(
    private val api: TrendYolApi): TrendYolRepository {

    override suspend fun getWidgets(): Resource<ListWidgets> {
        val response = try {
            api.getWidgets()
        } catch (e: Exception) {
            return Resource.Error(message = "Error: ${e.message}")
        }

        return Resource.Success(response)
    }
}