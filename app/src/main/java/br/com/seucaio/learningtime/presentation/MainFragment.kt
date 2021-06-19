package br.com.seucaio.learningtime.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.seucaio.learningtime.R
import br.com.seucaio.learningtime.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            val firstTitle = movies.results.first().title
            binding.title.text = firstTitle
        })

        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

        viewModel.hasError.observe(viewLifecycleOwner, Observer {
            if (it) {
                val message = "Erro desconhecido"
                binding.title.text = message
            }
        })

        binding.btnWatchlist.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_main_to_navigation_watchlist)
        }


        binding.btinFavorites.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.navigation_favorites,
                null
            )
        )

        binding.btnPopularMovies.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_main_to_popularMoviesFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}