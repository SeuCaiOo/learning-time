package br.com.seucaio.learningtime.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.com.seucaio.learningtime.R
import br.com.seucaio.learningtime.databinding.FragmentMainBinding

class MainFragment : Fragment() {

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
            findNavController().navigate(R.id.action_navigation_main_to_navigation_popular_movies)
        }
        binding.btnPopularTv.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_main_to_navigation_popular_tv)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}