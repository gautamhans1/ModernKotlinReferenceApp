package com.example.gautam.googlesamplesfetcher

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: GitRepoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}