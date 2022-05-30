package com.zotreex.sample_project.domain.usecases.getSampleList

import com.zotreex.sample_project.domain.data.Brand
import com.zotreex.sample_project.domain.data.ResponseResult
import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.repository.SpecificationRepository
import javax.inject.Inject

class GetSampleListUseCaseImpl @Inject constructor(
    private val specificationRepository: SpecificationRepository
) : GetSampleListUseCase {
    override suspend fun invoke(): ResponseResult<List<Brand>> = specificationRepository.getBrandList()
}