package br.com.seucaio.learningtime.domain.usecase.movie

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.domain.repository.TMDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPopularMoviesUseCase(private val repository: TMDBRepository) {

    suspend operator fun invoke(): TMDBResponse<PopularMovieResponse> =
        withContext(Dispatchers.IO) { repository.getPopularMovies() }

    suspend fun invokeAsync(): TMDBResponse<PopularMovieResponse> =
        withContext(Dispatchers.IO) { repository.getPopularMovies() }
}