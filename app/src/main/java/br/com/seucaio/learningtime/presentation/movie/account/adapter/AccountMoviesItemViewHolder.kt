package br.com.seucaio.learningtime.presentation.movie.account.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.core.adapter.OnItemClickListener
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.databinding.AccountMoviesItemBinding

class AccountMoviesItemViewHolder(private val binding: AccountMoviesItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: AccountMoviesResponse, openDetail: OnItemClickListener<AccountMoviesResponse>) {
        binding.textTitle.text = movie.title
        binding.textDescription.text = movie.overview
        binding.textRelease.text = movie.releaseDate
        binding.itemContainer.setOnClickListener { openDetail.onItemClick(movie) }
    }

}