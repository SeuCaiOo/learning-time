package br.com.seucaio.learningtime.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.databinding.PopularItemsBinding

class PopularAdapter<T>(
    private val list: List<T>,
    private val onItemClicked: OnItemClickListener<T>
) : RecyclerView.Adapter<PopularItemViewHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PopularItemsBinding.inflate(inflater, parent, false)
        return PopularItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder<T>, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

    override fun getItemCount(): Int = list.size

}
