package com.example.gautam.googlesamplesfetcher

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.example.gautam.googlesamplesfetcher.data.RepoModel
import com.example.gautam.googlesamplesfetcher.data.RepoModel.OnRepositoryReadyCallback
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import java.util.*

class MainViewModel : ViewModel() {
    var repoModel: RepoModel = RepoModel()
    val text = ObservableField("old data")
    var isLoading = ObservableField(false)

    var repositories = ArrayList<Repository>()


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