package com.hyden.daggersample.data.source

import com.hyden.daggersample.network.model.GithubResponse
import io.reactivex.Single

interface GithubDataSource {

    fun loadLanguage(
        type : String?,
        page : Int = 0
    ) : Single<GithubResponse>
}