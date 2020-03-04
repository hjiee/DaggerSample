package com.hyden.daggersample.di

import com.google.gson.Gson
import com.hyden.daggersample.network.api.GithubApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    //    @Provides
//    fun provideHeader() {
//
//    }
//

    @Provides
    @Named("domain")
    fun getDomain() : String {
        return "https://api.github.com/"
    }

    @Singleton
    @Provides
    fun provideApi(
        @Named("domain") domain : String
    ): GithubApi {

        return Retrofit.Builder()
            .baseUrl(domain)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }
}