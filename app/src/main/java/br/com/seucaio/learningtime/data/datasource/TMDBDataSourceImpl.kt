package br.com.seucaio.learningtime.data.datasource

import br.com.seucaio.learningtime.data.api.TMDBService
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.MovieDetailsResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.data.model.tv.TvDetailsResponse

class TMDBDataSourceImpl(
    private val service: TMDBService
) : TMDBDataSource {

    override suspend fun getPopularTV(): TMDBResponse<PopularTVResponse> {
        return service.getPopularTV()
    }

    override suspend fun getTvDetails(id: Int): TvDetailsResponse {
        return service.getTvDetails(tvId = id)
    }

    override suspend fun getPopularMovies(): TMDBResponse<PopularMovieResponse> {
        return service.getPopularMovies()
    }

    override suspend fun getMovieDetails(id: Int): MovieDetailsResponse {
        return service.getMovieDetails(movieId = id)
    }

    override suspend fun getWatchlistMovies(): TMDBResponse<AccountMoviesResponse> {
        return service.getWatchlistMovies()
    }

    override suspend fun getFavoriteMovies(): TMDBResponse<AccountMoviesResponse> {
        return service.getFavoritesMovies()
    }
}