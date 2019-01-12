package com.example.gautam.googlesamplesfetcher

import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.data.RepoModel
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnDataReadyCallback

class MainViewModel {
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField<String>()
    var isLoading = ObservableField<Boolean>()

    fun refresh() {
        isLoading.set(true)
        repoModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }
}