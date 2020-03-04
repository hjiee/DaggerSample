package com.hyden.daggersample.network.api

import com.hyden.daggersample.network.model.GithubResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    // language
    // https://developer.github.com/v3/search/#search-users
    @GET("search/repositories")
    fun getLanguage(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("page") page : Int
    ) : Single<GithubResponse>

    // repository
    // https://developer.github.com/v3/search/#search-users
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("page") page : Int
    ) : Single<GithubResponse>
}