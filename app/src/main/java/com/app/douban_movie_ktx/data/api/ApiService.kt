package com.app.douban_movie_ktx.data.api

import com.app.douban_movie_ktx.data.model.InTheaters
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        val baseUrl = "https://api.douban.com/v2/movie/"
    }

    @GET("in_theaters")
    fun getInTheaters(
        @Query("apikey") apikey: String, @Query("city") city: String
    ): Deferred<InTheaters>

}