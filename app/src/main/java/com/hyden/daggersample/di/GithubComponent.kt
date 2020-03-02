package com.hyden.daggersample.di

import com.hyden.daggersample.MainViewModel
import dagger.Component

@Component(
    modules = [
        (NetworkModule::class),
        (DiModule::class),
        (MainViewModel::class)
    ]
)
interface GithubComponent {
    fun inject()
}