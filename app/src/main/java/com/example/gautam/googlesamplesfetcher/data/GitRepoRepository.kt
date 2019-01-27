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

                /* Using .flatMap ,once remoteDataSource.getRepositories() emits item,
                that item will be mapped to new Observable that emits same item.
                That new Observable we created from Completable that saves the same
                emitted item in the local data store converting it to Single that emits
                the same emitted item. Cause we need to return Observable, we have to convert
                that Single to Observable. */

                return remoteDataSource.getRepositories().flatMap {
                    return@flatMap localDataSource.saveRepositories(it)
                        .toSingleDefault(it)
                        .toObservable()
                }
            }
        }
        return localDataSource.getRepositories()
    }
}