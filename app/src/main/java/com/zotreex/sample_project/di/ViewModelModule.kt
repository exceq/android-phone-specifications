package com.zotreex.sample_project.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zotreex.sample_project.ui.PhoneListViewModel
import com.zotreex.sample_project.ui.PhoneSpecificationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PhoneListViewModel::class)
    abstract fun phoneListViewModel(phoneListViewModel: PhoneListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PhoneSpecificationViewModel::class)
    abstract fun phoneSpecificationViewModel(phoneSpecificationViewModel: PhoneSpecificationViewModel): ViewModel
}