package br.com.seucaio.learningtime.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import br.com.seucaio.learningtime.R
import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    val useCase by inject<GetPopularMoviesUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            whenCreated {
                val movies: MovieResponse = useCase()
                Timber.i("${movies.results}")
            }
        }

    }
}