package com.zotreex.sample_project.domain.usecases.getSampleList

import com.zotreex.sample_project.domain.data.Brand
import com.zotreex.sample_project.domain.data.ResponseResult

interface GetSampleListUseCase {
    suspend operator fun invoke(): ResponseResult<List<Brand>>
}