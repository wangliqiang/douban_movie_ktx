package com.app.douban_movie_ktx.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.douban_movie_ktx.base.BaseViewModel
import com.app.douban_movie_ktx.data.HotRepository
import com.app.douban_movie_ktx.data.model.Theaters
import com.app.douban_movie_ktx.data.remote.ApiStatus
import kotlinx.coroutines.launch

class InTheatersViewModel : BaseViewModel() {

    init {
        getInTheatersData()
    }

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _InTheatersData = MutableLiveData<Theaters>()
    val theatersData: LiveData<Theaters>
        get() = _InTheatersData

    private fun getInTheatersData() {
        coroutineScope.launch {
            try {
                _status.value = ApiStatus.LOADING
                val response =
                    HotRepository.getInstance.getInTheaters(
                        "0df993c66c0c636e29ecbb5344252a4a",
                        "济南"
                    )
                _status.value = ApiStatus.DONE
                _InTheatersData.value = response
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _InTheatersData.value = null
            }
        }
    }

    fun onSwipeRefresh() {
        getInTheatersData()
    }

    fun retry() {
        getInTheatersData()
    }


}
