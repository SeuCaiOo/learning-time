package br.com.seucaio.learningtime.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.domain.usecase.movie.GetPopularMoviesUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class MovieViewModel(
    private val useCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<TMDBResponse<PopularMovieResponse>>()
    val tv: LiveData<TMDBResponse<PopularMovieResponse>>
        get() = _movies

    private val _progressBarVisible = MutableLiveData<Boolean>()
    val progressBarVisible: LiveData<Boolean> = _progressBarVisible

    private val _hasError = MutableLiveData<Boolean>()
    val hasError: LiveData<Boolean> = _hasError


    fun fetchPopularMovies() {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { useCase() }
                .onSuccess { response ->
                    _movies.value = response
                    Timber.d("${response.results}")
                }
                .onFailure {
                    Timber.e(it)
                    _hasError.value = true
                }
            _progressBarVisible.value = false
        }
    }

}