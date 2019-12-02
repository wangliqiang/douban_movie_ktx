package com.app.douban_movie_ktx.data

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
                ApiService.baseUrl
            )
        }
    }

    // 获取正咋热映数据
    suspend fun getInTheaters(apikey: String, city: String): Theaters {
        return apiService.getInTheaters(apikey, city)
    }

    // 获取即将上映数据
    suspend fun getComingSoon(apikey: String, city: String): Theaters {
        return apiService.getComingSoon(apikey, city)
    }
}