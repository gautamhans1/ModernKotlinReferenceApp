package com.example.gautam.googlesamplesfetcher.data

import android.os.Handler
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import java.util.ArrayList

class GitRepoLocalDataSource {
    fun getRepositories(onDataReadyCallback: GitRepoRepository.OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 1000, false))
        arrayList.add(Repository("Second", "Owner 2", 200, true))
        arrayList.add(Repository("Third", "Owner 3", 3000, false))

        Handler().postDelayed({ onDataReadyCallback.onDataReady(arrayList) }, 2000)
    }

    fun saveRepositories (arrayList : ArrayList<Repository>) {

    }

    interface OnRepoLocalReadyCallback {
        fun onLocalDataReady(data: ArrayList<Repository>)
    }

}