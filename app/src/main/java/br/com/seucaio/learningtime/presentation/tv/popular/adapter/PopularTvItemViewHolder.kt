package br.com.seucaio.learningtime.presentation.tv.popular.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.core.OnItemClickListener
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.databinding.PopularTvItemBinding

class PopularTvItemViewHolder(
    private val binding: PopularTvItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tv: PopularTVResponse, openDetail: OnItemClickListener<Int>) {
        binding.textTitle.text = tv.name
        binding.textDescription.text = tv.overview
        binding.textRelease.text = tv.firstAirDate
        binding.tvContainer.setOnClickListener { openDetail.onItemClick(tv.id) }
    }

}