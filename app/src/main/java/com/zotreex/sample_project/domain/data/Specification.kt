package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class Specification(
    @SerializedName("specs")
    val specs: List<Spec>,
    @SerializedName("title")
    val title: String
)