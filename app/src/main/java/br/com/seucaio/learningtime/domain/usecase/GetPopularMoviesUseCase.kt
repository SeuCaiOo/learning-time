package br.com.seucaio.learningtime.domain.usecase

import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.domain.repository.PopularRepository

class GetPopularMoviesUseCase(private val repository: PopularRepository) {

    suspend operator fun invoke(): MovieResponse = repository.getMovies()
}