package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.repository.SampleRepository
import com.zotreex.sample_project.domain.repository.SampleRepositoryImpl
import com.zotreex.sample_project.domain.usecases.getSampleItem.GetSampleItemUseCase
import com.zotreex.sample_project.domain.usecases.getSampleItem.GetSampleItemUseCaseImpl
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCase
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {
    @Binds
    fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository

    @Binds
    fun bindGetSampleListUseCase(useCase: GetSampleListUseCaseImpl): GetSampleListUseCase

    @Binds
    fun bindGetSampleItemUseCase(useCase: GetSampleItemUseCaseImpl): GetSampleItemUseCase
}