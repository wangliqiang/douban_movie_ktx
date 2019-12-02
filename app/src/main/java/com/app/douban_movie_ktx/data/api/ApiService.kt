package com.app.douban_movie_ktx.data.api

import com.app.douban_movie_ktx.data.model.Theaters
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        val baseUrl = "https://api.douban.com/v2/movie/"
    }

    @GET("in_theaters")
    suspend fun getInTheaters(
        @Query("apikey") apikey: String, @Query("city") city: String
    ): Theaters


    @GET("coming_soon")
    suspend fun getComingSoon(
        @Query("apikey") apikey: String, @Query("city") city: String
    ): Theaters

}