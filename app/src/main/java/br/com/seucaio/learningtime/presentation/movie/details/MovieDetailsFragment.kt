package br.com.seucaio.learningtime.presentation.movie.details

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import br.com.seucaio.learningtime.data.model.movie.MovieDetailsResponse
import br.com.seucaio.learningtime.databinding.FragmentMovieDetailsBinding
import br.com.seucaio.learningtime.presentation.movie.MovieViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchMovieDetails(9799)

        viewModel.movie.observe(viewLifecycleOwner, Observer { movie ->
            binding.tvOverview.text = movie.overview
            binding.tvReleaseDate.text = movie.releaseDate
            "%.1f".format(movie.popularity).also { binding.tvPopularity.text = it }
            binding.tvTitle.text = movie.title
            binding.tvTagline.text = movie.tagline
            setupImage(movie)
        })


        viewModel.progressBarVisible.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

    }

    private fun setupImage(movie: MovieDetailsResponse) {
        val baseUrl = "https://image.tmdb.org/t/p/original"
        val baseUrlW500 = "https://image.tmdb.org/t/p/w500"
        val url: String? = with(movie) { posterPath ?.let { "$baseUrl$it" } }

        binding.progressBar.visibility = View.VISIBLE;
        Glide.with(this@MovieDetailsFragment)
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
                    binding.progressBar.visibility = View.GONE;
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.progressBar.visibility = View.GONE;
                    return false // important to return false so the error placeholder can be placed
                }
            })
            .into(binding.imageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}