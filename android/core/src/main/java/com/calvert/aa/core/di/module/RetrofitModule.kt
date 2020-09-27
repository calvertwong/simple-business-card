package com.calvert.aa.core.di.module

import android.content.SharedPreferences
import com.calvert.aa.core.CoreConstants
import com.calvert.aa.core.network.HeaderInterceptor
import com.calvert.aa.core.network.RetrofitClient
import com.calvert.aa.core.network.UnsafeOkHttpClient
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val retrofitModule = module {
    single<OkHttpClient.Builder>(named("provideOkHttpClient")) {
        OkHttpClient.Builder()
    }

    single<OkHttpClient.Builder>(named("provideUnsafeOkHttpClient")) {
        UnsafeOkHttpClient.getUnsafeOkHttpClient()
    }

    single(named("provideRetrofit")) {
        RetrofitClient(
            baseUrl =
            with(get<SharedPreferences>(named("provideSharedPreferences"))) {
                if (this.getInt(CoreConstants.SERVER_ENV, CoreConstants.MOCK_POSITION) == CoreConstants.MOCK_POSITION)
                    this.getString(CoreConstants.MOCK_SERVER_IP, "").toString()
                else
                    this.getString(CoreConstants.PROD_SERVER_IP, "").toString()
            }
            ,
            okHttpClient =
            with(get<SharedPreferences>(named("provideSharedPreferences"))) {
                if (this.getInt(CoreConstants.SERVER_ENV, CoreConstants.MOCK_POSITION) == CoreConstants.MOCK_POSITION)
                    get<OkHttpClient.Builder>(named("provideUnsafeOkHttpClient"))
                else
                    get<OkHttpClient.Builder>(named("provideOkHttpClient"))
            },
            interceptorList = listOf(HeaderInterceptor())
        ).retrofitBuilder
    }
}