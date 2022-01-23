package tr.trendyol.interview.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tr.trendyol.interview.BuildConfig
import tr.trendyol.interview.data.TrendYolApi
import tr.trendyol.interview.data.repository.TrendYolRepositoryImpl
import tr.trendyol.interview.domain.repository.TrendYolRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTrendYolApi(): TrendYolApi =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL).build().create(TrendYolApi::class.java)

    @Provides
    @Singleton
    fun provideTrendYolRepository(api: TrendYolApi): TrendYolRepository =
        TrendYolRepositoryImpl(api)
}