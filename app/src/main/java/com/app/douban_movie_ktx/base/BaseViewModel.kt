package com.app.douban_movie_ktx.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.douban_movie_ktx.utils.Logger
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {


    private var viewModelJob = Job()

    val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}