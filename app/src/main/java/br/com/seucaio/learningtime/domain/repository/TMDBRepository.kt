package br.com.seucaio.learningtime.domain.repository

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse

interface TMDBRepository {
    suspend fun getPopularMovies(): TMDBResponse<PopularMovieResponse>
    suspend fun getPopularTV(): TMDBResponse<PopularTVResponse>
}