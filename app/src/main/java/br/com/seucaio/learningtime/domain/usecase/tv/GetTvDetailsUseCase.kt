package br.com.seucaio.learningtime.domain.usecase.tv

import br.com.seucaio.learningtime.data.model.tv.TvDetailsResponse
import br.com.seucaio.learningtime.domain.repository.TMDBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetTvDetailsUseCase(private val repository: TMDBRepository) {

    suspend operator fun invoke(tvId: Int): TvDetailsResponse =
        withContext(Dispatchers.IO) { repository.getTvDetails(tvId) }
}