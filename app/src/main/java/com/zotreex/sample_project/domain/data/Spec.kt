package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class Spec(
    @SerializedName("key")
    val key: String,
    @SerializedName("val")
    val value: List<String>
)