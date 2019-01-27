package com.example.gautam.googlesamplesfetcher

import android.content.Context
import com.example.gautam.googlesamplesfetcher.androidmanagers.NetManager
import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository

object Injection {

    private fun provideNetManager(context: Context): NetManager {
        return NetManager(context)
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