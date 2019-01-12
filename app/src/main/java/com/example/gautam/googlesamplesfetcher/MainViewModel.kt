package com.example.gautam.googlesamplesfetcher

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.data.RepoModel
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnDataReadyCallback

class MainViewModel : ViewModel(){
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    var isLoading = ObservableField(false)

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