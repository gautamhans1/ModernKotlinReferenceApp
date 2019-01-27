package com.example.gautam.googlesamplesfetcher

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository
import com.example.gautam.googlesamplesfetcher.extensions.plusAssign
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private var gitRepoRepository: GitRepoRepository) : ViewModel() {

    val text = ObservableField("old data")
    var isLoading = ObservableField(false)
    private val compositeDisposable = CompositeDisposable()

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepoRepository
            .getRepositories()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :
                DisposableObserver<ArrayList<Repository>>() {
                override fun onNext(data: ArrayList<Repository>) {
                    repositories.value = data
                }

                override fun onError(e: Throwable) {
                    // if some error in data layer we'll get the error here instead of crashing
                }

                override fun onComplete() {
                    isLoading.set(false)
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}