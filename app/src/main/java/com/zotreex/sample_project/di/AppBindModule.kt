package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.repository.SpecificationRepository
import com.zotreex.sample_project.domain.repository.SpecificationRepositoryImpl
import com.zotreex.sample_project.domain.usecases.getPhoneSpecification.GetPhoneSpecificationUseCase
import com.zotreex.sample_project.domain.usecases.getPhoneSpecification.GetPhoneSpecificationUseCaseImpl
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCase
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {
    @Binds
    fun bindSampleRepository(repository: SpecificationRepositoryImpl): SpecificationRepository

    @Binds
    fun bindGetSampleListUseCase(useCase: GetSampleListUseCaseImpl): GetSampleListUseCase

    @Binds
    fun bindGetSampleItemUseCase(useCasePhone: GetPhoneSpecificationUseCaseImpl): GetPhoneSpecificationUseCase
}