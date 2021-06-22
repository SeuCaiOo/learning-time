package br.com.seucaio.learningtime.presentation.movie.account.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.seucaio.learningtime.R
import br.com.seucaio.learningtime.core.adapter.OnItemClickListener
import br.com.seucaio.learningtime.data.model.movie.AccountMoviesResponse
import br.com.seucaio.learningtime.databinding.FragmentWatchlistMoviesBinding
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import br.com.seucaio.learningtime.presentation.movie.account.adapter.AccountMoviesAdapter
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
            setupAdapter(movies.results)
        })

        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

    }

    private fun setupAdapter(movies: List<AccountMoviesResponse>) {
        accountAdapter = AccountMoviesAdapter(
            movies,
            object : OnItemClickListener<AccountMoviesResponse> {
                override fun onItemClick(item: AccountMoviesResponse) {
                    navigateDetails(item)
                }
            })
        binding.recyclerPopularMovies.adapter = accountAdapter
    }

    private fun navigateDetails(accountResponse: AccountMoviesResponse) {
        val bundle = bundleOf("movieId" to accountResponse.id)
        findNavController()
            .navigate(
                R.id.action_navigation_watchlist_movies_to_navigation_movie_details,
                bundle,
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}