package com.example.gautam.googlesamplesfetcher

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.androidmanagers.NetManager
import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository
import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository.OnRepositoryReadyCallback
import com.example.gautam.googlesamplesfetcher.uimodel.Repository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetManager(getApplication()))
    val text = ObservableField("old data")
    var isLoading = ObservableField(false)

    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        gitRepoRepository.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }
        })
    }
}