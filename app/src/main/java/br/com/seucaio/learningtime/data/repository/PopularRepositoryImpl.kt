package br.com.seucaio.learningtime.data.repository

import br.com.seucaio.learningtime.data.datasource.PopularDataSource
import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.domain.repository.PopularRepository

class PopularRepositoryImpl(
    private val dataSource: PopularDataSource
) : PopularRepository {

    override suspend fun getMovies(): MovieResponse {
        return dataSource.getMovies()
    }
}