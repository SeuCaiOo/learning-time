package br.com.seucaio.learningtime.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.seucaio.learningtime.data.model.TMDBResponse
import br.com.seucaio.learningtime.data.model.tv.PopularTVResponse
import br.com.seucaio.learningtime.data.model.tv.TvDetailsResponse
import br.com.seucaio.learningtime.domain.usecase.tv.GetPopularTvUseCase
import br.com.seucaio.learningtime.domain.usecase.tv.GetTvDetailsUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

class TvViewModel(
    private val popularTvUseCase: GetPopularTvUseCase,
    private val tvDetailsUseCase: GetTvDetailsUseCase,
) : ViewModel() {

    private val _popularTv = MutableLiveData<TMDBResponse<PopularTVResponse>>()
    val popularTv: LiveData<TMDBResponse<PopularTVResponse>>
        get() = _popularTv

    private val _tv = MutableLiveData<TvDetailsResponse>()
    val tv: LiveData<TvDetailsResponse>
        get() = _tv

    private val _progressBarVisible = MutableLiveData<Boolean>()
    val progressBarVisible: LiveData<Boolean> = _progressBarVisible

    private val _hasError = MutableLiveData<Boolean>()
    val hasError: LiveData<Boolean> = _hasError

    init {
//        fetchPopularTV()
    }

    fun fetchTvDetails(tvId: Int) {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { tvDetailsUseCase(tvId) }
                .onSuccess { response ->
                    _tv.value = response
                    Timber.d("$response")
                }
                .onFailure {
                    Timber.e(it)
                    _hasError.value = true
                }
            _progressBarVisible.value = false
        }
    }


    fun fetchPopularTV() {
        _progressBarVisible.value = true
        viewModelScope.launch {
            runCatching { popularTvUseCase() }
                .onSuccess { response ->
                    _popularTv.value = response
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