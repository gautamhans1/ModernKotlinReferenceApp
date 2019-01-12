package com.example.gautam.googlesamplesfetcher

import com.example.gautam.googlesamplesfetcher.data.RepoModel;
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnDataReadyCallback;

class MainViewModel {
    var repoModel : RepoModel = RepoModel()
    var text : String = ""
    var isLoading : Boolean = false

    val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            text = data
        }
    }

    fun refresh () {
        repoModel.refreshData(onDataReadyCallback)
    }
}