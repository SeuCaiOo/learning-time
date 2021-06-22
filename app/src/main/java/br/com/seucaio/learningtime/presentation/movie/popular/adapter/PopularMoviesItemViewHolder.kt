package br.com.seucaio.learningtime.presentation.movie.popular.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.core.OnItemClickListener
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding

class PopularMoviesItemViewHolder(
    private val binding: PopularMoviesItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: PopularMovieResponse, openDetail: OnItemClickListener<Int>) {
        binding.textTitle.text = movie.title
        binding.textDescription.text = movie.overview
        binding.textRelease.text = movie.releaseDate
        binding.movieContainer.setOnClickListener { openDetail.onItemClick(movie.id) }
    }

}