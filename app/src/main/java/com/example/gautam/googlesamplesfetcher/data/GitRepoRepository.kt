package com.example.gautam.googlesamplesfetcher.data

import com.example.gautam.googlesamplesfetcher.androidmanagers.NetManager
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import io.reactivex.Observable


class GitRepoRepository(val netManager: NetManager) {

    val localDataSource = GitRepoLocalDataSource()
    val remoteDataSource = GitRepoRemoteDataSource()

    fun getRepositories(): Observable<ArrayList<Repository>> {

        netManager.isConnectedToInternet?.let {
            if (it) {
                // todo (2) save remote data to local db
                remoteDataSource.getRepositories()
            }
        }
        return localDataSource.getRepositories()
    }
}