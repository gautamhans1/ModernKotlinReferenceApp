package com.example.gautam.googlesamplesfetcher.androidmanagers

import android.content.Context
import android.net.ConnectivityManager

class NetManager(
    private var applicationContext: Context) {

    private var status : Boolean? = false

    val isConnectedToInternet : Boolean
        get() {
        val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = conManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

}