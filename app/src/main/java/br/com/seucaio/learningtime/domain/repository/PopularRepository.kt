package br.com.seucaio.learningtime.domain.repository

import br.com.seucaio.learningtime.data.model.MovieResponse

interface PopularRepository {
    suspend fun getMovies(): MovieResponse
}