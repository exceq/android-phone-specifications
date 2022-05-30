package com.zotreex.sample_project.domain.usecases.getPhoneSpecification

import com.zotreex.sample_project.domain.data.PhoneSpecification
import com.zotreex.sample_project.domain.data.ResponseResult

interface GetPhoneSpecificationUseCase {
    suspend operator fun invoke(phoneSlug: String): ResponseResult<PhoneSpecification>
}