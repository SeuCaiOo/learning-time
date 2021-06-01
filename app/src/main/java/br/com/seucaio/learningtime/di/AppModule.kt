package br.com.seucaio.learningtime.di

import br.com.seucaio.learningtime.data.api.BASE_URL
import br.com.seucaio.learningtime.data.api.MovieService
import br.com.seucaio.learningtime.data.datasource.PopularDataSource
import br.com.seucaio.learningtime.data.datasource.PopularDataSourceImpl
import br.com.seucaio.learningtime.data.repository.PopularRepositoryImpl
import br.com.seucaio.learningtime.domain.repository.PopularRepository
import br.com.seucaio.learningtime.domain.usecase.GetPopularMoviesUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    private fun providesOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor())
        .build()

    private fun providesGson(): Gson = GsonBuilder().create()

    private val dataModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(providesOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(providesGson()))
                .build()
                .create(MovieService::class.java)
        }
        factory<PopularDataSource> { PopularDataSourceImpl(service = get()) }
        factory<PopularRepository> { PopularRepositoryImpl(dataSource = get()) }
    }

    private val domainModule = module {
        factory { GetPopularMoviesUseCase(repository = get()) }
    }


    fun init() = loadKoinModules(listOf(dataModule, domainModule))
}