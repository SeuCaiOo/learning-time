package br.com.seucaio.learningtime.presentation.movie.account.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.core.adapter.OnItemClickListener
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.databinding.AccountMoviesItemBinding

class AccountMoviesAdapter(
    private val list: List<AccountMoviesResponse>,
    private val onItemClicked: OnItemClickListener<AccountMoviesResponse>
) : RecyclerView.Adapter<AccountMoviesItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountMoviesItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AccountMoviesItemBinding.inflate(inflater, parent, false)
        return AccountMoviesItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountMoviesItemViewHolder, position: Int) {
        holder.bind(list[position], onItemClicked)
    }

    override fun getItemCount(): Int = list.size

}
