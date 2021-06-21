package br.com.seucaio.learningtime.presentation.movie.account.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.AccountMoviesItemBinding
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding

class AccountMoviesItemViewHolder(private val binding: AccountMoviesItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: AccountMoviesResponse) {
        binding.textTitle.text = movie.title
        binding.textDescription.text = movie.overview
        binding.textRelease.text = movie.releaseDate
    }

}