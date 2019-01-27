package com.example.gautam.googlesamplesfetcher.data

import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class GitRepoLocalDataSource {
    fun getRepositories(): Observable<ArrayList<Repository>> {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from local", "Owner 1", 1000, false))
        arrayList.add(Repository("Second from local", "Owner 2", 200, true))
        arrayList.add(Repository("Third from local", "Owner 3", 3000, false))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>): Completable {

        /* Single.just(1) will create Single that emits just number 1.
         And adding delay of 1 second will delay the emitting by one second */

        return Single.just(1).delay(1, TimeUnit.SECONDS).toCompletable();
    }

}