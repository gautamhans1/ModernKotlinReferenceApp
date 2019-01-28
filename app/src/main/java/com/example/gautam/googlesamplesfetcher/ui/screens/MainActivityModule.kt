package com.example.gautam.googlesamplesfetcher.ui.screens

import android.arch.lifecycle.ViewModel
import com.example.gautam.googlesamplesfetcher.utility.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainActivityModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel


    /* @ContributesAndroidInjector annotation helps Dagger to wire up
    what is needed so we can inject instances in the specified activity.*/

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity
}