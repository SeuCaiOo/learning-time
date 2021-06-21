package br.com.seucaio.learningtime.presentation.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.MovieResponse
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding

class PopularMoviesAdapter(
    private val list: List<MovieResponse.Movie>
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
