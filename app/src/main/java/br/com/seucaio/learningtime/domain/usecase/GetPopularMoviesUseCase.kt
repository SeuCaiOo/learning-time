package br.com.seucaio.learningtime.domain.usecase

import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.domain.repository.PopularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPopularMoviesUseCase(private val repository: PopularRepository) {

    suspend operator fun invoke(): MovieResponse =
        withContext(Dispatchers.IO) { repository.getMovies() }

    suspend fun invokeAsync(): MovieResponse =
        withContext(Dispatchers.IO) { repository.getMovies() }
}