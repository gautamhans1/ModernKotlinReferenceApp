package com.example.gautam.googlesamplesfetcher.ui.screens

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.gautam.googlesamplesfetcher.R
import com.example.gautam.googlesamplesfetcher.ui.rvadapters.RepositoryRecyclerViewAdapter
import com.example.gautam.googlesamplesfetcher.databinding.ActivityMainBinding
import com.example.gautam.googlesamplesfetcher.ui.uimodels.Repository
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter =
        RepositoryRecyclerViewAdapter(arrayListOf(), this)
    @Inject lateinit var viewModelFactory : ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(
            this,
            Observer<ArrayList<Repository>> { it?.let { repositoryRecyclerViewAdapter.replaceData(it) } })
    }

    override fun onItemClick(position: Int) {

    }

}
