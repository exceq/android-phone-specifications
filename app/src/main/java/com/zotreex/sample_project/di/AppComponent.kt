package com.zotreex.sample_project.di

import com.zotreex.sample_project.ui.PhoneListFragment
import com.zotreex.sample_project.ui.PhoneSpecificationFragment
import com.zotreex.sample_project.ui.SearchFragment
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: PhoneListFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: PhoneSpecificationFragment)

    fun viewModelFactory() : ViewModelFactory
}

@Module(includes = [NetworkModule::class, AppBindModule::class, ViewModelModule::class])
class AppModule
