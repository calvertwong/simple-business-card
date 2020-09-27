package com.calvert.aa.core.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitClient(
    baseUrl: String,
    private val okHttpClient: OkHttpClient.Builder,
    private val interceptorList: List<Interceptor>
) {
    private fun buildHttpClient(): OkHttpClient {
        if (interceptorList.isNotEmpty()) {
            interceptorList.forEach {
                okHttpClient.addInterceptor(it)
            }
        }
        return okHttpClient.build()
    }

    val retrofitBuilder: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(buildHttpClient())
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}