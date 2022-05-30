package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.api.PhoneSpecificationsService
import com.zotreex.sample_project.domain.data.*
import javax.inject.Inject

class SpecificationRepositoryImpl @Inject constructor(
    private val phoneSpecificationsService: PhoneSpecificationsService
) : SpecificationRepository {
    override suspend fun getBrandList(): ResponseResult<List<Brand>> {
        return phoneSpecificationsService.getBrandList()
    }

    override suspend fun getBrandPhoneList(brand_slug: String, page: Int?): ResponseResult<PhonePage> {
        return phoneSpecificationsService.getBrandPhoneList(brand_slug, page)
    }

    override suspend fun getPhoneSpecification(phone_slug: String): ResponseResult<PhoneSpecification> {
        return phoneSpecificationsService.getPhoneSpecification(phone_slug)
    }

    override suspend fun getSearchResult(query: String): ResponseResult<PhoneList> {
        return phoneSpecificationsService.getSearchResult(query)
    }

    override suspend fun getLatest(): ResponseResult<PhoneList> {
        return phoneSpecificationsService.getLatest()
    }

    override suspend fun getTopByInterest(): ResponseResult<PhoneList> {
        return phoneSpecificationsService.getTopByInterest()
    }

    override suspend fun getTopByFans(): ResponseResult<PhoneList> {
        return phoneSpecificationsService.getTopByFans()
    }
}