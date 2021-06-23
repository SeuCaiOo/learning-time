package br.com.seucaio.learningtime.presentation.movie.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.seucaio.learningtime.core.adapter.OnItemClickListener
import br.com.seucaio.learningtime.core.adapter.PopularAdapter
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.FragmentPopularMoviesBinding
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : Fragment() {

    private var _binding: FragmentPopularMoviesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModel()

    private val directions = PopularMoviesFragmentDirections

    private lateinit var moviesAdapter: PopularAdapter<PopularMovieResponse>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchPopularMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            setupAdapter(movies.results)
        })

        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })
    }

    private fun setupAdapter(movies: List<PopularMovieResponse>) {
        moviesAdapter = PopularAdapter(
            movies,
            object : OnItemClickListener<PopularMovieResponse> {
                override fun onItemClick(item: PopularMovieResponse) {
                    navigateDetails(item)
                }
            })
        binding.recyclerPopularMovies.adapter = moviesAdapter
    }

    private fun navigateDetails(movieResponse: PopularMovieResponse) {
        findNavController().navigate(
            directions.actionNavigationPopularMoviesToNavigationMovieDetails(
                movieId = movieResponse.id
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}