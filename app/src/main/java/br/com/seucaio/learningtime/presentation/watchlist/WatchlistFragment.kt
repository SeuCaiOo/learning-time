package br.com.seucaio.learningtime.presentation.watchlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.seucaio.learningtime.databinding.FragmentWatchlistBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchlistFragment : Fragment() {

    private val viewModel: WatchlistViewModel by viewModel()
    private var _binding: FragmentWatchlistBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}