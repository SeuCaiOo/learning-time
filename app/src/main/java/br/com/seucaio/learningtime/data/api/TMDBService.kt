package br.com.seucaio.learningtime.data.api

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.MovieDetailsResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.data.model.tv.TvDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "f75668f284196298b8f92a5f6ae732dc"
const val LANGUAGE_PT_BR = "pt-BR"
const val PAGE_ONE = "1"
const val ACCOUNT_ID = 8301451
const val SESSION_ID = "b62a6596ea7dcfbc243ba1e67c02d36f56c2a9da"

interface TMDBService {

    @GET("tv/popular")
    suspend fun getPopularTV(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_PT_BR,
        @Query("page") page: String = PAGE_ONE
    ): TMDBResponse<PopularTVResponse>

    @GET("tv/{id}")
    suspend fun getTvDetails(
        @Path("id") tvId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_PT_BR
    ): TvDetailsResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_PT_BR,
        @Query("page") page: String = PAGE_ONE
    ): TMDBResponse<PopularMovieResponse>

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE_PT_BR
    ): MovieDetailsResponse

    @GET("account/${ACCOUNT_ID}/watchlist/movies")
    suspend fun getWatchlistMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("session_id") sessionId: String = SESSION_ID,
        @Query("language") language: String = LANGUAGE_PT_BR,
    ) : TMDBResponse<AccountMoviesResponse>

    @GET("account/${ACCOUNT_ID}/favorite/movies")
    suspend fun getFavoritesMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("session_id") sessionId: String = SESSION_ID,
        @Query("language") language: String = LANGUAGE_PT_BR,
    ) : TMDBResponse<AccountMoviesResponse>

}
