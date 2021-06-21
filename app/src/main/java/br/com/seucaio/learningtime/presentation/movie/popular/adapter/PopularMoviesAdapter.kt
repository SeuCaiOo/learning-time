package br.com.seucaio.learningtime.presentation.movie.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding
import br.com.seucaio.learningtime.presentation.tv.popular.adapter.PopularTvItemViewHolder

class PopularMoviesAdapter(
    private val list: List<PopularMovieResponse>
) : RecyclerView.Adapter<PopularMoviesItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularMoviesItemBinding.inflate(inflater, parent, false)
        return PopularMoviesItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMoviesItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}
