package com.zotreex.sample_project.domain.api

import com.zotreex.sample_project.domain.data.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhoneSpecificationsService {
    @GET("brands")
    suspend fun getBrandList(): ResponseResult<List<Brand>>

    @GET("brands/{brand_slug}")
    suspend fun getBrandPhoneList(
        @Query("brand_slug") brand_slug: String,
        @Query("page") page: Int?
    ): ResponseResult<PhonePage>

    @GET("{phone_slug}")
    suspend fun getPhoneSpecification(@Path("phone_slug") phone_slug: String): ResponseResult<PhoneSpecification>

    @GET("search")
    suspend fun getSearchResult(@Query("query") query: String): ResponseResult<PhoneList>

    @GET("latest")
    suspend fun getLatest(): ResponseResult<PhoneList>

    @GET("top-by-interest")
    suspend fun getTopByInterest(): ResponseResult<PhoneList>

    @GET("top-by-fans")
    suspend fun getTopByFans(): ResponseResult<PhoneList>
}