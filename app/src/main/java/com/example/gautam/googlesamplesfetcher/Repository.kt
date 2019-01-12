package com.example.gautam.googlesamplesfetcher

import android.databinding.BaseObservable
import android.databinding.Bindable

class Repository(
    repositoryName: String, var repositoryOwner: String?,
    var numberOfStars: Int?, var hasIssues: Boolean = false
) : BaseObservable() {

    @get: Bindable
    var repositoryName = repositoryName
        set (value) {
            field = value
            notifyPropertyChanged(BR.repositoryName)
        }
}
