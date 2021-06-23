package br.com.seucaio.learningtime.presentation.tv.details

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.data.model.tv.TvDetailsResponse
import br.com.seucaio.learningtime.databinding.FragmentTvDetailsBinding
import br.com.seucaio.learningtime.presentation.tv.TvViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvDetailsFragment : Fragment() {

    private var _binding: FragmentTvDetailsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: TvViewModel by viewModel()

    val args: TvDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTvDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val popularTv = arguments?.getParcelable<PopularTVResponse>("tv")
        val tvId = popularTv?.id ?: 2190

        viewModel.fetchTvDetails(tvId)
        viewModel.tv.observe(viewLifecycleOwner, Observer { tv ->
            binding.tvOverview.text = tv.overview
            binding.tvReleaseDate.text = tv.firstAirDate
            "%.1f".format(tv.voteAverage).also { binding.tvPopularity.text = it }
            binding.tvTitle.text = tv.name
            binding.tvTagline.text = tv.tagline
            setupImage(tv)
        })

        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

    }

    private fun setupImage(tv: TvDetailsResponse) {
        val baseUrl = "https://image.tmdb.org/t/p/original"
        val baseUrlW500 = "https://image.tmdb.org/t/p/w500"
        val url: String = with(tv) { posterPath.let { "$baseUrl$it" } }

        binding.progressBar.visibility = View.VISIBLE;
        Glide.with(this)
            .load(url)
            .transform(CircleCrop())
//            .centerCrop()
//            .fitCenter()
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressBar.visibility = View.GONE
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressBar.visibility = View.GONE
                    return false
                }
            })
            .into(binding.imageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}