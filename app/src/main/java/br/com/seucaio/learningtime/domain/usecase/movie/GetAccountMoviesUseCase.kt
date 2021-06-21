package br.com.seucaio.learningtime.domain.usecase.movie

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.domain.repository.TMDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAccountMoviesUseCase(private val repository: TMDBRepository) {

    suspend fun watchlist(): TMDBResponse<AccountMoviesResponse> =
        withContext(Dispatchers.IO) { repository.getWatchlistMovies() }

    suspend fun favorite(): TMDBResponse<AccountMoviesResponse> =
        withContext(Dispatchers.IO) { repository.getFavoriteMovies() }
}