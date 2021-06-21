package br.com.seucaio.learningtime.data.repository

import br.com.seucaio.learningtime.data.datasource.TMDBDataSource
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.domain.repository.TMDBRepository

class TMDBRepositoryImpl(
    private val dataSource: TMDBDataSource
) : TMDBRepository {

    override suspend fun getPopularMovies(): TMDBResponse<PopularMovieResponse> {
        return dataSource.getPopularMovies()
    }

    override suspend fun getPopularTV(): TMDBResponse<PopularTVResponse> {
        return dataSource.getPopularTV()
    }

    override suspend fun getWatchlistMovies(): TMDBResponse<AccountMoviesResponse> {
        return dataSource.getWatchlistMovies()
    }

    override suspend fun getFavoriteMovies(): TMDBResponse<AccountMoviesResponse> {
        return dataSource.getFavoriteMovies()
    }
}