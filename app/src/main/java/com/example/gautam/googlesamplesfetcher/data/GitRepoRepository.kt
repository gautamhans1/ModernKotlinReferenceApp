package com.example.gautam.googlesamplesfetcher.data

import android.content.Context
import com.example.gautam.googlesamplesfetcher.androidmanagers.NetManager
import com.example.gautam.googlesamplesfetcher.data.GitRepoRemoteDataSource.OnRepoRemoteReadyCallback
import com.example.gautam.googlesamplesfetcher.data.GitRepoLocalDataSource.OnRepoLocalReadyCallback
import com.example.gautam.googlesamplesfetcher.uimodel.Repository


class GitRepoRepository (val netManager: NetManager) {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {

        netManager.isConnectedToInternet?.let {
            if(it) {
                remoteDataSource.getRepositories(object : OnRepoRemoteReadyCallback {
                    override fun onRemoteDataReady(data: ArrayList<Repository>) {
                        localDataSource.saveRepositories(data)
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            } else {
                localDataSource.getRepositories(object : OnRepoLocalReadyCallback {
                    override fun onLocalDataReady(data: java.util.ArrayList<Repository>) {
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            }
        }

    }

    interface OnRepositoryReadyCallback {
        fun onDataReady(data: ArrayList<Repository>)
    }

}