package br.com.seucaio.learningtime.presentation.popular.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding

class PopularMoviesItemViewHolder(private val binding: PopularMoviesItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieResponse.Movie) {
        binding.textTitle.text = movie.title
        binding.textDescription.text = movie.overview
        binding.textRelease.text = movie.releaseDate
    }

}