package br.com.seucaio.learningtime.presentation.tv.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.seucaio.learningtime.databinding.FragmentPopularTvBinding
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import br.com.seucaio.learningtime.presentation.tv.TvViewModel
import br.com.seucaio.learningtime.presentation.tv.popular.adapter.PopularTvAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularTvFragment : Fragment() {

    //    private val viewModel: WatchlistViewModel by viewModel()
    private var _binding: FragmentPopularTvBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: TvViewModel by viewModel()

    private lateinit var tvAdapter: PopularTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tv.observe(viewLifecycleOwner, Observer { tv ->
            tvAdapter = PopularTvAdapter(tv.results)
            binding.recyclerPopularMovies.adapter = tvAdapter
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