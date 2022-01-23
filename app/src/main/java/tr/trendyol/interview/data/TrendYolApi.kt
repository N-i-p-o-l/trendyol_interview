package tr.trendyol.interview.data

import retrofit2.http.GET
import tr.trendyol.interview.domain.entity.ListWidgets

interface TrendYolApi {

    @GET("/mobile-zeus-zeus-service/widget/display/personalized?widgetPageName=interview&platform=android")
    suspend fun getWidgets(): ListWidgets
}