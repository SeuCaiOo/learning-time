package br.com.seucaio.learningtime.data.datasource

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse

interface TMDBDataSource {
    suspend fun getPopularMovies(): TMDBResponse<PopularMovieResponse>
    suspend fun getPopularTV(): TMDBResponse<PopularTVResponse>
}