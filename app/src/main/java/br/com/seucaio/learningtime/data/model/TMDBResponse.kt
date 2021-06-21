package br.com.seucaio.learningtime.data.model


import com.google.gson.annotations.SerializedName

data class TMDBResponse<T>(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)