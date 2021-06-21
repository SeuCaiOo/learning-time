package br.com.seucaio.learningtime.domain.usecase.tv

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.domain.repository.TMDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPopularTvUseCase(private val repository: TMDBRepository) {

    suspend operator fun invoke(): TMDBResponse<PopularTVResponse> =
        withContext(Dispatchers.IO) { repository.getPopularTV() }

}