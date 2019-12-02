package com.app.douban_movie_ktx.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.douban_movie_ktx.base.BaseViewModel
import com.app.douban_movie_ktx.data.HotRepository
import com.app.douban_movie_ktx.data.model.Theaters
import com.app.douban_movie_ktx.data.remote.ApiStatus
import kotlinx.coroutines.launch

class ComingSoonViewModel : BaseViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _commingSoonData = MutableLiveData<Theaters>()
    val commingSoonData: LiveData<Theaters>
        get() = _commingSoonData

    init {
        getCommingSoonData()
    }

    private fun getCommingSoonData() {
        coroutineScope.launch {
            try {
                _status.value = ApiStatus.LOADING
                val response = HotRepository.getInstance.getComingSoon(
                    "0df993c66c0c636e29ecbb5344252a4a",
                    "济南"
                )
                _status.value = ApiStatus.DONE
                _commingSoonData.value = response
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _commingSoonData.value = null
            }
        }
    }


    fun onSwipeRefresh() {
        getCommingSoonData()
    }

    fun retry() {
        getCommingSoonData()
    }
}