package com.example.gautam.googlesamplesfetcher

import com.example.gautam.googlesamplesfetcher.ui.screens.MainActivityModule
import com.example.gautam.googlesamplesfetcher.utility.di.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        ViewModelBuilder::class]
)

interface AppComponent : AndroidInjector<ModernApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ModernApplication>()

}