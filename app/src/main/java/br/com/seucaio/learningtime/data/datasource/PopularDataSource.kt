package br.com.seucaio.learningtime.data.datasource

import br.com.seucaio.learningtime.data.model.MovieResponse

interface PopularDataSource {
    suspend fun getMovies(): MovieResponse
}