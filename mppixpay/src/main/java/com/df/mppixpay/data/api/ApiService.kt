package com.df.mppixpay.data.api

import com.df.mppixpay.util.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    //private var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(
            OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .callTimeout(30, TimeUnit.SECONDS)
                //.addInterceptor(logging)
                .build()
        )
        .addConverterFactory(MoshiConverterFactory.create()/*.asLenient()*/)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val callApi: CallApi
        get() = retrofit.create(CallApi::class.java)

}