package br.com.seucaio.learningtime.di

import br.com.seucaio.learningtime.data.api.BASE_URL
import br.com.seucaio.learningtime.data.api.TMDBService
import br.com.seucaio.learningtime.data.datasource.TMDBDataSource
import br.com.seucaio.learningtime.data.datasource.TMDBDataSourceImpl
import br.com.seucaio.learningtime.data.repository.TMDBRepositoryImpl
import br.com.seucaio.learningtime.domain.repository.TMDBRepository
import br.com.seucaio.learningtime.domain.usecase.movie.GetPopularMoviesUseCase
import br.com.seucaio.learningtime.domain.usecase.tv.GetPopularTvUseCase
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import br.com.seucaio.learningtime.presentation.tv.TvViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    private fun providesOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private fun providesGson(): Gson = GsonBuilder().create()

    private val dataModule = module {
        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(providesOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(providesGson()))
                .build()
                .create(TMDBService::class.java)
        }
        factory<TMDBDataSource> { TMDBDataSourceImpl(service = get()) }
        factory<TMDBRepository> { TMDBRepositoryImpl(dataSource = get()) }
    }

    private val domainModule = module {
        factory { GetPopularMoviesUseCase(repository = get()) }
        factory { GetPopularTvUseCase(repository = get()) }
    }

    private val presentationModule = module {

        viewModel<MovieViewModel> {
            MovieViewModel(useCase = get())
        }

        viewModel<TvViewModel> {
            TvViewModel(useCase = get())
        }

    }


    fun init() = loadKoinModules(listOf(dataModule, domainModule, presentationModule))
}