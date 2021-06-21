package br.com.seucaio.learningtime.presentation.movie.account.watchlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import br.com.seucaio.learningtime.databinding.FragmentWatchlistMoviesBinding
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import br.com.seucaio.learningtime.presentation.movie.account.adapter.AccountMoviesAdapter
import br.com.seucaio.learningtime.presentation.movie.popular.adapter.PopularMoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchlistMoviesFragment : Fragment() {

    private var _binding: FragmentWatchlistMoviesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModel()

    private lateinit var accountAdapter: AccountMoviesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWatchlistMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchWatchlistMovies()

        viewModel.accountMovies.observe(viewLifecycleOwner, Observer { movies ->
            accountAdapter = AccountMoviesAdapter(movies.results)
            binding.recyclerPopularMovies.adapter = accountAdapter
        })

        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}