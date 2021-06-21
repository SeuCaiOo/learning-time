package br.com.seucaio.learningtime.data.api

import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "f75668f284196298b8f92a5f6ae732dc"
const val ACCOUNT_ID = 8301451
const val SESSION_ID = "b62a6596ea7dcfbc243ba1e67c02d36f56c2a9da"

interface TMDBService {

    @GET("tv/popular")
    suspend fun getPopularTV(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "pt-BR",
        @Query("page") page: String = "1"
    ): TMDBResponse<PopularTVResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "pt-BR",
        @Query("page") page: String = "1"
    ): TMDBResponse<PopularMovieResponse>

//    @GET("account/${ACCOUNT_ID}/favorite/movies")
//    suspend fun getFavoritesMovies(
//        @Query("api_key") apiKey: String = API_KEY,
//        @Query("session_id") sessionId: String = SESSION_ID,
//    ) : MovieResponse
//
//    @GET("account/${ACCOUNT_ID}/watchlist/movies")
//    suspend fun getWatchlistMovies(
//        @Query("api_key") apiKey: String = API_KEY,
//        @Query("session_id") sessionId: String = SESSION_ID,
//    ) : MovieResponse


}