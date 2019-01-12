package com.example.gautam.googlesamplesfetcher

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.data.RepoModel
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnDataReadyCallback
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnRepositoryReadyCallback
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import java.util.ArrayList

class MainViewModel : ViewModel(){
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    var isLoading = ObservableField(false)

    var repositories = ArrayList<Repository>()

    fun refresh() {
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories = data
            }
        })
    }
}