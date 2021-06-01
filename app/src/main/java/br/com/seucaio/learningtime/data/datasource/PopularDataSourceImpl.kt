package br.com.seucaio.learningtime.data.datasource

import br.com.seucaio.learningtime.data.api.MovieService
import br.com.seucaio.learningtime.data.model.MovieResponse

class PopularDataSourceImpl(
    private val service: MovieService
) : PopularDataSource {

    override suspend fun getMovies(): MovieResponse = service.getPopularMovies()
}