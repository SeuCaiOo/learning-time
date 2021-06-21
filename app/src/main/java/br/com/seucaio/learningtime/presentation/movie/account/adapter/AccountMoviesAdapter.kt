package br.com.seucaio.learningtime.presentation.movie.account.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.AccountMoviesItemBinding
import br.com.seucaio.learningtime.databinding.PopularMoviesItemBinding
import br.com.seucaio.learningtime.presentation.tv.popular.adapter.PopularTvItemViewHolder

class AccountMoviesAdapter(
    private val list: List<AccountMoviesResponse>
) : RecyclerView.Adapter<AccountMoviesItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountMoviesItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AccountMoviesItemBinding.inflate(inflater, parent, false)
        return AccountMoviesItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountMoviesItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}
