package com.example.gautam.googlesamplesfetcher

import com.example.gautam.googlesamplesfetcher.data.GitRepoRepository
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providesMainViewModelFactory(gitRepoRepository: GitRepoRepository) :MainViewModelFactory {
            return MainViewModelFactory(gitRepoRepository)
        }
    }

    /* @ContributesAndroidInjector annotation helps Dagger to wire up
    what is needed so we can inject instances in the specified activity.*/

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity
}