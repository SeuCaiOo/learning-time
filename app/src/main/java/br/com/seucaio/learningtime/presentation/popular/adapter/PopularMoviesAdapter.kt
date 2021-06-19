package br.com.seucaio.learningtime.presentation.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding

class PopularMoviesAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PopularMoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularMoviesItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textTitle.text = list[position]
    }

    override fun getItemCount(): Int = list.size

}
