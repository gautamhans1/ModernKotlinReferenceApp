package com.example.gautam.googlesamplesfetcher

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.data.RepoModel
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnRepositoryReadyCallback
import com.example.gautam.googlesamplesfetcher.uimodel.Repository

class MainViewModel : ViewModel() {
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    var isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}