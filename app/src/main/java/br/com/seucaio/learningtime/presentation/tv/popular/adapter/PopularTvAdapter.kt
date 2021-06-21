package br.com.seucaio.learningtime.presentation.tv.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding
import br.com.seucaio.learningtime.databinding.PopularTvItemBinding

class PopularTvAdapter(
    private val list: List<PopularTVResponse>
) : RecyclerView.Adapter<PopularTvItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTvItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularTvItemBinding.inflate(inflater, parent, false)
        return PopularTvItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularTvItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}
