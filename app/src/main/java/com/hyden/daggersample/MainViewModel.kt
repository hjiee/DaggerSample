package com.hyden.daggersample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyden.daggersample.data.source.GithubDataSource
import com.hyden.daggersample.network.model.GithubResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.ThreadPoolExecutor
import javax.inject.Inject

class MainViewModel (
    private val gihubDataSource: GithubDataSource
) : ViewModel() {

    lateinit var disposable : Disposable

    private val _githubInfo = MutableLiveData<List<GithubResponse.Items>>()
    val githubInfo : LiveData<List<GithubResponse.Items>> get() = _githubInfo

    fun loadLanguage() {
        disposable = gihubDataSource.loadLanguage("javascript")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ _githubInfo.value = it.items },{ Log.e("error","Error : $it")})
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}