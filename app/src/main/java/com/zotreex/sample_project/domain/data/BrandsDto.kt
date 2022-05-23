package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class BrandsDto(
    @SerializedName("data")
    val brands: List<Brand>,
    @SerializedName("status")
    val status: Boolean
)