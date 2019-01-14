package com.example.gautam.googlesamplesfetcher.data

import com.example.gautam.googlesamplesfetcher.data.GitRepoRemoteDataSource.OnRepoRemoteReadyCallback
import com.example.gautam.googlesamplesfetcher.uimodel.Repository


class GitRepoRepository {

    var localDataSource = GitRepoLocalDataSource()
    var remoteDataSource = GitRepoRemoteDataSource()


    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        remoteDataSource.getRepositories(object : OnRepoRemoteReadyCallback {
            override fun onRemoteDataReady(data: ArrayList<Repository>) {
                localDataSource.saveRepositories(data)
                onRepositoryReadyCallback.onDataReady(data)
            }
        })
    }

    interface OnRepositoryReadyCallback {
        fun onDataReady(data: ArrayList<Repository>)
    }

}