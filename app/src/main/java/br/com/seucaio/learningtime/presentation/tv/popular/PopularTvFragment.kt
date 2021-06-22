package br.com.seucaio.learningtime.presentation.tv.popular

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
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.databinding.FragmentPopularTvBinding
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

        viewModel.fetchPopularTV()
        viewModel.popularTv.observe(viewLifecycleOwner, Observer { tv ->
            setupAdapter(tv.results)
        })

        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

    }

    private fun setupAdapter(tvs: List<PopularTVResponse>) {
        tvAdapter = PopularTvAdapter(
            tvs,
            object : OnItemClickListener<Int> {
                override fun onItemClick(item: Int) = navigateDetails(item)
            })
        binding.recyclerPopularMovies.adapter = tvAdapter
    }

    private fun navigateDetails(id: Int) {
        val bundle = bundleOf("tvId" to id)
        findNavController()
            .navigate(
                R.id.action_navigation_popular_tv_to_navigation_tv_details,
                bundle,
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}