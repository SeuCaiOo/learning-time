package br.com.seucaio.learningtime.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import br.com.seucaio.learningtime.R
import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import timber.log.Timber
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val useCase by inject<GetPopularMoviesUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            whenCreated {
                val movies = async { useCase.invokeAsync() }
                runCatching {
//                    getMovies()
                    movies.await()
                }
                    .onSuccess { response -> Timber.d("${response.results}") }
                    .onFailure { Timber.e(it) }


            }
        }

    }

    private suspend fun getMovies() {
        val movies: MovieResponse = useCase()
        Timber.i("${movies.results}")
    }

}