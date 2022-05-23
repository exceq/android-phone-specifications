package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("brand_id")
    val brandId: Int,
    @SerializedName("brand_name")
    val brandName: String,
    @SerializedName("brand_slug")
    val brandSlug: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("device_count")
    val deviceCount: Int
)