package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.data.*

interface SpecificationRepository {
    suspend fun getBrandList(): ResponseResult<List<Brand>>

    suspend fun getBrandPhoneList(brand_slug: String, page: Int?): ResponseResult<PhonePage>

    suspend fun getPhoneSpecification(phone_slug: String): ResponseResult<PhoneSpecification>

    suspend fun getSearchResult(query: String): ResponseResult<PhoneList>

    suspend fun getLatest(): ResponseResult<PhoneList>

    suspend fun getTopByInterest(): ResponseResult<PhoneList>

    suspend fun getTopByFans(): ResponseResult<PhoneList>
}