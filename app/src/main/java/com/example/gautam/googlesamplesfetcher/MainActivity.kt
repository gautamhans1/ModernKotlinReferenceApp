package com.example.gautam.googlesamplesfetcher

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.gautam.googlesamplesfetcher.databinding.ActivityMainBinding
import com.example.gautam.googlesamplesfetcher.uimodel.Repository

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var repository = Repository(
        "Git Repo", "Gautam Hans",
        1000, true
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.repository = repository
        binding.executePendingBindings()

        Handler().postDelayed({repository.repositoryName="GGWP"
        }, 2000)

    }
}
