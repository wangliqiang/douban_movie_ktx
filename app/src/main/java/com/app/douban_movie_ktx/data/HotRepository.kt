package com.app.douban_movie_ktx.data

import com.app.douban_movie_ktx.BuildConfig
import com.app.douban_movie_ktx.data.api.ApiService
import com.app.douban_movie_ktx.data.model.Theaters
import com.app.douban_movie_ktx.data.remote.RetrofitClient

class HotRepository {

    companion object {
        val getInstance: HotRepository by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HotRepository()
        }

        // 初始化网络请求
        private val apiService: ApiService by lazy {
            RetrofitClient().getService(
                ApiService::class.java,
                BuildConfig.MOVIE_BASE_URL
            )
        }
    }

    // 获取正在热映数据
    suspend fun getInTheaters(city: String): Theaters {
        return apiService.getInTheaters(city)
    }

    // 获取即将上映数据
    suspend fun getComingSoon(apikey: String, city: String): Theaters {
        return apiService.getComingSoon(apikey, city)
    }
}