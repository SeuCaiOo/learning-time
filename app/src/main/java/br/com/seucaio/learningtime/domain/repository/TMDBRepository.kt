package br.com.seucaio.learningtime.domain.repository

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.MovieDetailsResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.data.model.tv.TvDetailsResponse

interface TMDBRepository {
    suspend fun getPopularTV(): TMDBResponse<PopularTVResponse>

    suspend fun getTvDetails(id: Int): TvDetailsResponse

    suspend fun getPopularMovies(): TMDBResponse<PopularMovieResponse>

    suspend fun getMovieDetails(id: Int): MovieDetailsResponse

    suspend fun getWatchlistMovies(): TMDBResponse<AccountMoviesResponse>

    suspend fun getFavoriteMovies(): TMDBResponse<AccountMoviesResponse>
}