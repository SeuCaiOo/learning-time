package br.com.seucaio.learningtime.data.api

import br.com.seucaio.learningtime.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "f75668f284196298b8f92a5f6ae732dc"

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "pt-BR",
        @Query("page") page: String = "1"
    ): MovieResponse
}