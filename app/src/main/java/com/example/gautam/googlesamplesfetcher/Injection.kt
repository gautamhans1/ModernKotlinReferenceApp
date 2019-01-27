package com.example.gautam.googlesamplesfetcher

import android.content.Context
import com.example.gautam.googlesamplesfetcher.androidmanagers.NetManager
import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository

object Injection {

    private var NET_MANAGER: NetManager? = null

    private fun provideNetManager(context: Context): NetManager {
        if (NET_MANAGER == null) {
            NET_MANAGER = NetManager(context)
        }
        return NET_MANAGER!!
    }

    private fun gitRepoRepository(netManager: NetManager): GitRepoRepository {
        return GitRepoRepository(netManager)
    }

    fun provideMainViewModelFactory(context: Context): MainViewModelFactory {
        val netManager = provideNetManager(context)
        val repository = gitRepoRepository(netManager)
        return MainViewModelFactory(repository)
    }
}