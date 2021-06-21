package br.com.seucaio.learningtime.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.domain.usecase.movie.GetAccountMoviesUseCase
import br.com.seucaio.learningtime.domain.usecase.movie.GetPopularMoviesUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class MovieViewModel(
    private val popularMoviesUseCase: GetPopularMoviesUseCase,
    private val accountMoviesUseCase: GetAccountMoviesUseCase,
) : ViewModel() {

    private val _movies = MutableLiveData<TMDBResponse<PopularMovieResponse>>()
    val movie: LiveData<TMDBResponse<PopularMovieResponse>>
        get() = _movies

    private val _accountMovies = MutableLiveData<TMDBResponse<AccountMoviesResponse>>()
    val accountMovies: LiveData<TMDBResponse<AccountMoviesResponse>>
        get() = _accountMovies

    private val _progressBarVisible = MutableLiveData<Boolean>()
    val progressBarVisible: LiveData<Boolean> = _progressBarVisible

    private val _hasError = MutableLiveData<Boolean>()
    val hasError: LiveData<Boolean> = _hasError


    fun fetchPopularMovies() {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { popularMoviesUseCase() }
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


    fun fetchWatchlistMovies() {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { accountMoviesUseCase.watchlist() }
                .onSuccess { response ->
                    _accountMovies.value = response
                    Timber.d("${response.results}")
                }
                .onFailure {
                    Timber.e(it)
                    _hasError.value = true
                }
            _progressBarVisible.value = false
        }
    }

    fun fetchFavoriteMovies() {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { accountMoviesUseCase.favorite() }
                .onSuccess { response ->
                    _accountMovies.value = response
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