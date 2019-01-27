package com.example.gautam.googlesamplesfetcher.data

import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class GitRepoLocalDataSource {
    fun getRepositories(): Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from local", "Owner 1", 1000, false))
        arrayList.add(Repository("Second from local", "Owner 2", 200, true))
        arrayList.add(Repository("Third from local", "Owner 3", 3000, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>) {
        // TODO(1) save repositories in database
    }

}