package com.hyden.daggersample.di

import com.hyden.daggersample.base.BaseApplication
import dagger.Component

@Component(modules = [
        (NetworkModule::class)])
interface GithubComponent {


    fun inject(app : BaseApplication)
}