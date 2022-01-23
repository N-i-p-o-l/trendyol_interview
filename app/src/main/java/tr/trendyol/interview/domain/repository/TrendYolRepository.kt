package tr.trendyol.interview.domain.repository

import tr.trendyol.interview.common.Resource
import tr.trendyol.interview.domain.entity.ListWidgets

interface TrendYolRepository {

    suspend fun getWidgets(): Resource<ListWidgets>
}