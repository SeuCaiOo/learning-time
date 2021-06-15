package br.com.seucaio.learningtime.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import br.com.seucaio.learningtime.R
import br.com.seucaio.learningtime.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root)

        setSupportActionBar(binding.toolbar)

        viewModel.movies.observe(this, Observer { movies ->
            val firstTitle = movies.results.first().title
            binding.title.text = firstTitle
        })

        viewModel.progressBarVisible.observe(this, Observer {
            binding.progressBar.isVisible =it
        })

        viewModel.hasError.observe(this, Observer {
            if (it) {
                val message = "Erro desconhecido"
                binding.title.text = message
            }
        })
    }

}