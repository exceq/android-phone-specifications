package com.zotreex.sample_project.domain.usecases.getPhoneSpecification

import com.zotreex.sample_project.domain.data.PhoneSpecification
import com.zotreex.sample_project.domain.data.ResponseResult
import com.zotreex.sample_project.domain.repository.SpecificationRepository
import javax.inject.Inject

class GetPhoneSpecificationUseCaseImpl @Inject constructor(
    private val specificationRepository: SpecificationRepository
) : GetPhoneSpecificationUseCase {
    override suspend fun invoke(phoneSlug: String): ResponseResult<PhoneSpecification> =
        specificationRepository.getPhoneSpecification(phoneSlug)
}