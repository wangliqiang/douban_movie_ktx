package com.app.douban_movie_ktx.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.douban_movie_ktx.base.BaseViewModel
import com.app.douban_movie_ktx.data.api.ApiService
import com.app.douban_movie_ktx.data.model.InTheaters
import com.app.douban_movie_ktx.data.remote.ApiStatus
import com.app.douban_movie_ktx.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class InTheatersViewModel : BaseViewModel() {

    // 初始化网络请求
    private val apiService: ApiService by lazy {
        RetrofitClient().getService(
            ApiService::class.java,
            ApiService.baseUrl
        )
    }

    init {
        getInTheatersData()
    }


    private val _status = MutableLiveData<ApiStatus>()

    val status: LiveData<ApiStatus>
        get() = _status

    private val _InTheatersData = MutableLiveData<InTheaters>()

    val InTheatersData: LiveData<InTheaters>
        get() = _InTheatersData


    private fun getInTheatersData() {
        coroutineScope.launch {
            try {
                _status.value = ApiStatus.LOADING
                val response = apiService.getInTheaters("0df993c66c0c636e29ecbb5344252a4a","济南")
                _status.value = ApiStatus.DONE
                _InTheatersData.value = response
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _InTheatersData.value = null
            }
        }
    }


}
