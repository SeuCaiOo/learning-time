package br.com.seucaio.learningtime.data.datasource

import br.com.seucaio.learningtime.data.api.TMDBService
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse

class TMDBDataSourceImpl(
    private val service: TMDBService
) : TMDBDataSource {

    override suspend fun getPopularMovies(): TMDBResponse<PopularMovieResponse> {
        return service.getPopularMovies()
    }

    override suspend fun getPopularTV(): TMDBResponse<PopularTVResponse> {
        return service.getPopularTV()
    }
}