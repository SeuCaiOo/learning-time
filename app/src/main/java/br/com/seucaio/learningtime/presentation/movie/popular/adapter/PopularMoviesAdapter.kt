package br.com.seucaio.learningtime.presentation.movie.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.core.OnItemClickListener
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding

class PopularMoviesAdapter(
    private val list: List<PopularMovieResponse>,
    private val onItemClicked: OnItemClickListener<Int>
) : RecyclerView.Adapter<PopularMoviesItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularMoviesItemBinding.inflate(inflater, parent, false)
        return PopularMoviesItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMoviesItemViewHolder, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

    override fun getItemCount(): Int = list.size

}
