package br.com.seucaio.learningtime.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.domain.usecase.tv.GetPopularTvUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class TvViewModel(
    private val useCase: GetPopularTvUseCase
) : ViewModel() {

    private val _tv = MutableLiveData<TMDBResponse<PopularTVResponse>>()
    val tv: LiveData<TMDBResponse<PopularTVResponse>>
        get() = _tv

    private val _progressBarVisible = MutableLiveData<Boolean>()
    val progressBarVisible: LiveData<Boolean> = _progressBarVisible

    private val _hasError = MutableLiveData<Boolean>()
    val hasError: LiveData<Boolean> = _hasError

    init {
        fetchPopularTV()
    }


    private fun fetchPopularTV() {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { useCase() }
                .onSuccess { response ->
                    _tv.value = response
                    Timber.d("${response.results}")
                }
                .onFailure {
                    Timber.e(it)
                    _hasError.value = true
                }
            _progressBarVisible.value = false
        }
    }

}