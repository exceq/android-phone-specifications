package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class PhoneList(
    @SerializedName("phones")
    val phones: List<Phone>,
    @SerializedName("title")
    val title: String
)
