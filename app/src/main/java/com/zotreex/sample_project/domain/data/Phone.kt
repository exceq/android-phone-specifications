package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class Phone(
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("phone_name")
    val phoneName: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("hits")
    val hits: Int?,
    @SerializedName("favorites")
    val favorites: Int?
)