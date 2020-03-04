package com.hyden.daggersample.data

import com.hyden.daggersample.data.source.GithubDataSource
import com.hyden.daggersample.network.api.GithubApi
import com.hyden.daggersample.network.model.GithubResponse
import io.reactivex.Single

class GithubRepository(
    private val githubApi: GithubApi
) : GithubDataSource {

    override fun loadLanguage(type: String?, page: Int) : Single<GithubResponse> {
        return githubApi.getLanguage("language:${type}", "stars", "desc", page)
    }
}