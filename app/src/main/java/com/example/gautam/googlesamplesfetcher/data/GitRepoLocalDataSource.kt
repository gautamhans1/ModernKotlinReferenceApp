package com.example.gautam.googlesamplesfetcher.data

import android.os.Handler
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import java.util.ArrayList

class GitRepoLocalDataSource {
    fun getRepositories(onDataReadyCallback: OnRepoLocalReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First from local", "Owner 1", 1000, false))
        arrayList.add(Repository("Second from local", "Owner 2", 200, true))
        arrayList.add(Repository("Third from local", "Owner 3", 3000, false))

        Handler().postDelayed({ onDataReadyCallback.onLocalDataReady(arrayList) }, 2000)
    }

    fun saveRepositories (arrayList : ArrayList<Repository>) {

    }

    interface OnRepoLocalReadyCallback {
        fun onLocalDataReady(data: ArrayList<Repository>)
    }

}