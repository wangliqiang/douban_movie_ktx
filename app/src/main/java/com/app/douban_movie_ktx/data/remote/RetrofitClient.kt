package com.app.douban_movie_ktx.data.remote

import com.app.douban_movie_ktx.BuildConfig
import com.app.douban_movie_ktx.utils.Logger
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object CLIENT {
        private const val TIMEOUT: Long = 60
    }

    protected val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()
            val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                override fun log(message: String) {
                    Logger.e(message)
                }
            })
            if (BuildConfig.DEBUG) {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            } else {
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            }

            builder.addInterceptor(loggingInterceptor)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)

            return builder.build()
        }



    open fun <Service> getService(serviceClass: Class<Service>, baseUrl: String): Service {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .baseUrl(baseUrl)
            .build()
            .create(serviceClass)
    }
}