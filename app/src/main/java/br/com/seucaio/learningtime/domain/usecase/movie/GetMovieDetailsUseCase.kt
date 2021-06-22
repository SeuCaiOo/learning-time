package br.com.seucaio.learningtime.domain.usecase.movie

import br.com.seucaio.learningtime.data.model.movie.MovieDetailsResponse
import br.com.seucaio.learningtime.domain.repository.TMDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetMovieDetailsUseCase(private val repository: TMDBRepository) {

    suspend operator fun invoke(movieId: Int): MovieDetailsResponse =
        withContext(Dispatchers.IO) { repository.getMovieDetails(movieId) }
}