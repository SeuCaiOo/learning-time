package br.com.seucaio.learningtime.core.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.databinding.PopularItemsBinding

class PopularItemViewHolder<T>(
    private val binding: PopularItemsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T, openDetail: OnItemClickListener<T>) {
        binding.itemContainer.setOnClickListener { openDetail.onItemClick(item) }
        when (item) {
            is PopularMovieResponse -> {
                val movie = item as PopularMovieResponse
                binding.textTitle.text = movie.title
                binding.textDescription.text = movie.overview
                binding.textRelease.text = movie.releaseDate
            }
            is PopularTVResponse -> {
                val tv = item as PopularTVResponse
                binding.textTitle.text = tv.name
                binding.textDescription.text = tv.overview
                binding.textRelease.text = tv.firstAirDate
            }

        }
    }

}