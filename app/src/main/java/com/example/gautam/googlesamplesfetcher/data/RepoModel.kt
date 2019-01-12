package com.example.gautam.googlesamplesfetcher.data

import android.os.Handler
import com.example.gautam.googlesamplesfetcher.uimodel.Repository
import java.util.ArrayList

class RepoModel {

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new data") }, 2000)
    }

    fun getRepositories(onDataReadyCallback: OnRepositoryReadyCallback) {
        var arrayList = ArrayList<Repository>()
        arrayList.add(Repository("First", "Owner 1", 1000, false))
        arrayList.add(Repository("Second", "Owner 2", 200, true))
        arrayList.add(Repository("Third", "Owner 3", 3000, false))

        Handler().postDelayed({onDataReadyCallback.onDataReady(arrayList)}, 2000)
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: String)
    }

    interface OnRepositoryReadyCallback {
        fun onDataReady(data: ArrayList<Repository>)
    }

}