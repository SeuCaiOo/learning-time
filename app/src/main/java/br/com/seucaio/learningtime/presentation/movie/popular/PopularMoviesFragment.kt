package br.com.seucaio.learningtime.presentation.movie.popular

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
import br.com.seucaio.learningtime.core.OnItemClickListener
import br.com.seucaio.learningtime.data.model.movie.PopularMovieResponse
import br.com.seucaio.learningtime.databinding.FragmentPopularMoviesBinding
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import br.com.seucaio.learningtime.presentation.movie.popular.adapter.PopularMoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : Fragment() {

    private var _binding: FragmentPopularMoviesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModel()

    private lateinit var moviesAdapter: PopularMoviesAdapter

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
        moviesAdapter = PopularMoviesAdapter(
            movies,
            object : OnItemClickListener<Int> {
                override fun onItemClick(item: Int) = navigateDetails(item)
            })
        binding.recyclerPopularMovies.adapter = moviesAdapter
    }

    private fun navigateDetails(id: Int) {
        val bundle = bundleOf("movieId" to id)
        findNavController()
            .navigate(
                R.id.action_navigation_popular_movies_to_navigation_movie_details,
                bundle,
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}