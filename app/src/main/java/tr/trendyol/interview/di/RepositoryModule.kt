package tr.trendyol.interview.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tr.trendyol.interview.data.TrendYolApi
import tr.trendyol.interview.data.repository.TrendYolRepositoryImpl
import tr.trendyol.interview.domain.repository.TrendYolRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTrendYolRepository(api: TrendYolApi): TrendYolRepository {
        return TrendYolRepositoryImpl(api)
    }
}